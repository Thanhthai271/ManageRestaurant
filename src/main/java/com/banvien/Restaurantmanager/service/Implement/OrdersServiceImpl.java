package com.banvien.Restaurantmanager.service.Implement;

import com.banvien.Restaurantmanager.repository.*;
import com.banvien.Restaurantmanager.service.OrdersService;
import com.banvien.Restaurantmanager.domain.entity.*;
import com.banvien.Restaurantmanager.domain.request.OrdersRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {


    private final OrdersRepository ordersRepository;
    private final CustomerRespository customerRespository;
    private final DinningTableRepository tablesRepository;
    private final EmployeesRepository employeesRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final FoodRepository foodRepository;

    @Override
    public List<OrdersEntity> getAllOrder() {
        return ordersRepository.findAll();
    }

    @Override
    public OrdersEntity getOrder(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    @Override
    public void saveOrder(OrdersRequest request) {
        OrdersEntity orders = new OrdersEntity();

        CustomerEntity customerIdEntity = request.getCustomerId() != null ? customerRespository
                .findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found")) : null;

        EmployeesEntity employees = request.getEmployeeId() != null ? employeesRepository
                .findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found")) : null;

        orders.setCustomer(customerIdEntity);
        orders.setEmployee(employees);


        // create order
        OrdersEntity ordersEntity = ordersRepository.save(orders);

        // create order detail
        List<OrderDetailsEntity> orderDetailsEntities = new ArrayList<>();
        for (int i = 0; i < request.getOrderDetails().size(); i++) {
            OrderDetailsEntity orderDetails = new OrderDetailsEntity();
            orderDetails.setQuanity(request.getOrderDetails().get(i).getQuantity());

            FoodEntity foodEntity = foodRepository.findById(request.getOrderDetails().get(i).getFoodId()).orElse(null);
            orderDetails.setFood(foodEntity);
        }

        orders.setPaymentStatus(request.getStatus());


        orderDetailsRepository.saveAll(orderDetailsEntities);
    }

@Override
    public void updateOrder(Long id, OrdersRequest request) {
        OrdersEntity existingOrder = ordersRepository.findById(id).orElse(null);

        CustomerEntity customerEntity = request.getCustomerId() != null ? customerRespository
                .findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found")) : null;

        EmployeesEntity employeesEntity = request.getEmployeeId() != null ? employeesRepository
                .findById(request.getEmployeeId())
                        .orElseThrow(() -> new RuntimeException("Employee not found")) : null;

        existingOrder.setEmployee(employeesEntity);
        existingOrder.setCustomer(customerEntity);

    OrdersEntity ordersEntity = ordersRepository.save(existingOrder);

    // create order detail
    List<OrderDetailsEntity> orderDetailsEntities = new ArrayList<>();
    for (int i = 0; i < request.getOrderDetails().size(); i++) {
        OrderDetailsEntity orderDetails = new OrderDetailsEntity();
        orderDetails.setQuanity(request.getOrderDetails().get(i).getQuantity());

        FoodEntity foodEntity = foodRepository.findById(request.getOrderDetails().get(i).getFoodId()).orElse(null);
        orderDetails.setFood(foodEntity);
    }

    existingOrder.setPaymentStatus(request.getStatus());
    if ("paid".equalsIgnoreCase(request.getStatus())) {
        existingOrder.setPaymentStatus(null);
    }

    orderDetailsRepository.saveAll(orderDetailsEntities);
    }

    @Override
    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}
