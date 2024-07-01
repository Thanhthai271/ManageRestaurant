package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.OrdersRepository;
import com.banvien.Restaurantmanager.Service.OrdersService;
import com.banvien.Restaurantmanager.domain.entity.OrdersEntity;
import com.banvien.Restaurantmanager.domain.request.OrdersRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public List<OrdersEntity> getAllEntity() {
        return ordersRepository.findAll();
    }

    @Override
    public OrdersEntity getOrder(Long id) {
        return ordersRepository.findById(id).orElse(null);
    }

    @Override
    public OrdersEntity saveOrder(OrdersRequest request) {
        OrdersEntity orders = new OrdersEntity();
        orders.setOrderDateTime(request.getOrderDateTime());
        orders.setTotalAmounts(request.getTotalAmount());
        orders.setStatus(request.getStatus());
        return ordersRepository.save(orders);
    }

    @Override
    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}
