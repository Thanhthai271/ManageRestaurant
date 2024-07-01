package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.OrderDetailsRepository;
import com.banvien.Restaurantmanager.Service.OrderDetailsService;
import com.banvien.Restaurantmanager.domain.entity.OrderDetailsEntity;
import com.banvien.Restaurantmanager.domain.request.OrderDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailsRepository orderDetailsRepository;

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
        return orderDetailsRepository.save(orderDetails);
    }

    @Override
    public void deleteOrderDetail(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}
