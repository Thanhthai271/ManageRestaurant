package com.banvien.Restaurantmanager.Service;

import com.banvien.Restaurantmanager.domain.entity.OrderDetailsEntity;
import com.banvien.Restaurantmanager.domain.request.OrderDetailsRequest;

import java.util.List;

public interface OrderDetailsService {
    List<OrderDetailsEntity> getAllOrderDetails();
    OrderDetailsEntity getOrderDetail(Long id);
    OrderDetailsEntity saveOrderDetail(OrderDetailsRequest request);
    OrderDetailsEntity updateOrderDetail(Long id, OrderDetailsRequest request);
    void deleteOrderDetail(Long id);
}
