package com.banvien.Restaurantmanager.Service;

import com.banvien.Restaurantmanager.domain.entity.OrderDetailsEntity;
import com.banvien.Restaurantmanager.domain.entity.OrderDrinksEntity;
import com.banvien.Restaurantmanager.domain.request.OrderDetailsRequest;
import com.banvien.Restaurantmanager.domain.request.OrderDrinksRequest;

import java.util.List;

public interface OrderDrinksService {
    List<OrderDrinksEntity> getAllOrderDrinks();
    OrderDrinksEntity getOrderDrink(Long id);
    OrderDrinksEntity saveOrderDrink(OrderDrinksRequest request);
    OrderDrinksEntity updateOrderDrink(Long id, OrderDrinksRequest request);
    void deleteOrderDrink(Long id);
}
