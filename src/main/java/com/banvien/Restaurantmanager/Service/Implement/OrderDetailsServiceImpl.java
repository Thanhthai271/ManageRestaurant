package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.*;
import com.banvien.Restaurantmanager.Service.OrderDetailsService;
import com.banvien.Restaurantmanager.domain.entity.*;
import com.banvien.Restaurantmanager.domain.request.OrderDetailsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {

   private final OrdersRepository ordersRepository;
   private final DishRepository dishRepository;
   private final OrderDrinksRepository orderDrinksRepository;
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
        orderDetails.setQuanity(request.getQuanity());
        orderDetails.setPrice(request.getPrice());

        OrdersEntity ordersIdEntity = ordersRepository
                .findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        DishEntity dishIdEntity = dishRepository
                .findById(request.getDishId())
                .orElseThrow(() -> new RuntimeException("Dish not found"));

        OrderDrinksEntity orderDrinksId = orderDrinksRepository
                .findById(request.getOrderDrinkId())
                .orElseThrow(() -> new RuntimeException("OrderDrink not found"));

        EmployeesEntity employeeId = employeesRepository
                .findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        orderDetails.setOrderId(ordersIdEntity);
        orderDetails.setDishId(dishIdEntity);
        orderDetails.setOrderDrinkId(orderDrinksId);
        orderDetails.setEmployeeId(employeeId);

        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public OrderDetailsEntity updateOrderDetail(Long id, OrderDetailsRequest request) {
        OrderDetailsEntity existingOrderDetail = orderDetailsRepository.findById(id).orElse(null);
        existingOrderDetail.setQuanity(request.getQuanity());
        existingOrderDetail.setPrice(request.getPrice());

        OrdersEntity ordersIdEntity = ordersRepository
                .findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        DishEntity dishIdEntity = dishRepository
                .findById(request.getDishId())
                .orElseThrow(() -> new RuntimeException("Dish not found"));

        OrderDrinksEntity orderDrinksId = orderDrinksRepository
                .findById(request.getOrderDrinkId())
                .orElseThrow(() -> new RuntimeException("OrderDrink not found"));

        EmployeesEntity employeeId = employeesRepository
                .findById(request.getEmployeeId())
                        .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingOrderDetail.setOrderId(ordersIdEntity);
        existingOrderDetail.setDishId(dishIdEntity);
        existingOrderDetail.setOrderDrinkId(orderDrinksId);
        existingOrderDetail.setEmployeeId(employeeId);
        return orderDetailsRepository.save(existingOrderDetail);
    }

    @Override
    public void deleteOrderDetail(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}
