package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.DrinksRepository;
import com.banvien.Restaurantmanager.Repository.OrderDrinksRepository;
import com.banvien.Restaurantmanager.Repository.OrdersRepository;
import com.banvien.Restaurantmanager.Service.OrderDrinksService;
import com.banvien.Restaurantmanager.domain.entity.DrinksEntity;
import com.banvien.Restaurantmanager.domain.entity.OrderDrinksEntity;
import com.banvien.Restaurantmanager.domain.entity.OrdersEntity;
import com.banvien.Restaurantmanager.domain.request.OrderDrinksRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderDrinksServiceImpl implements OrderDrinksService {

    private final OrderDrinksRepository orderDrinksRepository;
    private final OrdersRepository ordersRepository;
    private final DrinksRepository drinksRepository;

    @Override
    public List<OrderDrinksEntity> getAllOrderDrinks() {
        return orderDrinksRepository.findAll();
    }

    @Override
    public OrderDrinksEntity getOrderDrink(Long id) {
        return orderDrinksRepository.findById(id).orElse(null);
    }

    @Override
    public OrderDrinksEntity saveOrderDrink(OrderDrinksRequest request) {
        OrderDrinksEntity orderDrinksEntity = new OrderDrinksEntity();
        orderDrinksEntity.setQuanity(request.getQuanity());
        orderDrinksEntity.setPrice(request.getPrice());

        OrdersEntity orderIdEntity = ordersRepository
                .findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        DrinksEntity drinkIdEntity = drinksRepository
                .findById(request.getDrinkId())
                .orElseThrow(() -> new RuntimeException("Drink not found"));

        orderDrinksEntity.setOrderId(orderIdEntity);
        orderDrinksEntity.setDrinkId(drinkIdEntity);
        return orderDrinksRepository.save(orderDrinksEntity);
    }

    @Override
    public OrderDrinksEntity updateOrderDrink(Long id, OrderDrinksRequest request) {
        OrderDrinksEntity existingOrderDrinks = orderDrinksRepository.findById(id).orElse(null);
        existingOrderDrinks.setQuanity(request.getQuanity());
        existingOrderDrinks.setPrice(request.getPrice());

        OrdersEntity orderIdEntity = ordersRepository
                .findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        DrinksEntity drinkIdEntity = drinksRepository
                .findById(request.getDrinkId())
                .orElseThrow(() -> new RuntimeException("Drink not found"));

        existingOrderDrinks.setOrderId(orderIdEntity);
        existingOrderDrinks.setDrinkId(drinkIdEntity);
        return orderDrinksRepository.save(existingOrderDrinks);
    }

    @Override
    public void deleteOrderDrink(Long id) {
        orderDrinksRepository.deleteById(id);
    }
}
