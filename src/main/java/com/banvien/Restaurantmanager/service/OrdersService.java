package com.banvien.Restaurantmanager.service;

import com.banvien.Restaurantmanager.domain.entity.OrdersEntity;
import com.banvien.Restaurantmanager.domain.request.OrdersRequest;
import com.banvien.Restaurantmanager.domain.response.DTO.DTOOrder;

import java.util.List;

public interface OrdersService {
    public List<DTOOrder> GetAllOrders();
    OrdersEntity getOrder(Long id);
    void saveOrder(OrdersRequest request);
    void updateOrder(Long id, OrdersRequest request);
    void deleteOrder(Long id);
}
