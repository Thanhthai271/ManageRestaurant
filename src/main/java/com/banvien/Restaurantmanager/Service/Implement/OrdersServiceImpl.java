package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.CustomerRespository;
import com.banvien.Restaurantmanager.Repository.OrdersRepository;
import com.banvien.Restaurantmanager.Repository.DinningTableRepository;
import com.banvien.Restaurantmanager.Service.OrdersService;
import com.banvien.Restaurantmanager.domain.entity.CustomerEntity;
import com.banvien.Restaurantmanager.domain.entity.OrdersEntity;
import com.banvien.Restaurantmanager.domain.entity.DinningTableEntity;
import com.banvien.Restaurantmanager.domain.request.OrdersRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {


    private final OrdersRepository ordersRepository;
    private final CustomerRespository customerRespository;
    private final DinningTableRepository tablesRepository;

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

        CustomerEntity customerIdEntity = customerRespository
                .findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        DinningTableEntity tablesEntityId = tablesRepository
                .findById((request.getDinningTableId()))
                .orElseThrow(() -> new RuntimeException("Table not found"));

        orders.setCustomerId(customerIdEntity);
        orders.setDinningTableId(tablesEntityId);
        return ordersRepository.save(orders);
    }

    @Override
    public OrdersEntity updateOrder(Long id, OrdersRequest request) {
        OrdersEntity existingOrder = ordersRepository.findById(id).orElse(null);
        existingOrder.setOrderDateTime(request.getOrderDateTime());

        DinningTableEntity tableIdEntity = tablesRepository
                .findById(request.getDinningTableId())
                .orElseThrow(() -> new RuntimeException("Table not found"));

        CustomerEntity customerIdEntity = customerRespository
                .findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        existingOrder.setDinningTableId(tableIdEntity);
        existingOrder.setCustomerId(customerIdEntity);
        return ordersRepository.save(existingOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        ordersRepository.deleteById(id);
    }
}
