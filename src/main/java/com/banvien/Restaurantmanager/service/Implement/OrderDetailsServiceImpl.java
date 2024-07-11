package com.banvien.Restaurantmanager.service.Implement;

import com.banvien.Restaurantmanager.repository.*;
import com.banvien.Restaurantmanager.service.OrderDetailsService;
import com.banvien.Restaurantmanager.domain.entity.*;
import com.banvien.Restaurantmanager.domain.request.OrderDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {

   private final OrdersRepository ordersRepository;
   private final FoodRepository foodRepository;
   private final EmployeesRepository employeesRepository;

    private final OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<OrderDetailsEntity> getAllOrderDetails() {
        return orderDetailsRepository.findAll();
    }

    @Override
    public OrderDetailsEntity getOrderDetail(Long id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public OrderDetailsEntity saveOrderDetail(OrderDetailsRequest request) {
        OrderDetailsEntity orderDetails = new OrderDetailsEntity();
        orderDetails.setQuanity(request.getQuantity());
        orderDetails.setPrice(request.getPrice());

        OrdersEntity ordersIdEntity = ordersRepository
                .findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        FoodEntity foodEntity = foodRepository
                .findById(request.getFoodId())
                .orElseThrow(() -> new RuntimeException("Food not found with : " + request.getFoodId()));

        EmployeesEntity employeeId = employeesRepository
                .findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));


        orderDetails.setFood(foodEntity);
        orderDetails.setOrder(ordersIdEntity);
        orderDetails.setEmployee(employeeId);

        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetailsEntity updateOrderDetail(Long id, OrderDetailsRequest request) {
        OrderDetailsEntity existingOrderDetail = orderDetailsRepository.findById(id).orElse(null);
        existingOrderDetail.setQuanity(request.getQuantity());
        existingOrderDetail.setPrice(request.getPrice());

        OrdersEntity ordersIdEntity = ordersRepository
                .findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        FoodEntity foodEntity = foodRepository
                .findById(request.getFoodId())
                .orElseThrow(() -> new RuntimeException("Food not found with : " + request.getFoodId()));

        EmployeesEntity employeeId = employeesRepository
                .findById(request.getEmployeeId())
                        .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingOrderDetail.setFood(foodEntity);
        existingOrderDetail.setOrder(ordersIdEntity);
        existingOrderDetail.setEmployee(employeeId);
        return orderDetailsRepository.save(existingOrderDetail);
    }

    @Override
    public void deleteOrderDetail(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}
