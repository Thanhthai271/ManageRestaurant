package com.banvien.Restaurantmanager.Service;

import com.banvien.Restaurantmanager.domain.entity.OrdersEntity;
import com.banvien.Restaurantmanager.domain.request.OrdersRequest;

import java.util.List;

public interface OrdersService {
    List<OrdersEntity> getAllEntity();
    OrdersEntity getOrder(Long id);
    OrdersEntity saveOrder(OrdersRequest request);
    OrdersEntity updateOrder(Long id, OrdersRequest request);
    void deleteOrder(Long id);
}
