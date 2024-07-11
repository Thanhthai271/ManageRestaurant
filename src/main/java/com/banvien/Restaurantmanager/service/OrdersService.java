package com.banvien.Restaurantmanager.service;

import com.banvien.Restaurantmanager.domain.entity.OrdersEntity;
import com.banvien.Restaurantmanager.domain.request.OrdersRequest;

import java.util.List;

public interface OrdersService {
    List<OrdersEntity> getAllOrder();
    OrdersEntity getOrder(Long id);
    void saveOrder(OrdersRequest request);
    void updateOrder(Long id, OrdersRequest request);
    void deleteOrder(Long id);
}
