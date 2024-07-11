package com.banvien.Restaurantmanager.service.Implement;

import com.banvien.Restaurantmanager.repository.BillsRepository;
import com.banvien.Restaurantmanager.repository.OrdersRepository;
import com.banvien.Restaurantmanager.service.BillsService;
import com.banvien.Restaurantmanager.domain.entity.BillsEntity;
import com.banvien.Restaurantmanager.domain.entity.OrdersEntity;
import com.banvien.Restaurantmanager.domain.request.BillsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BillsServiceImpl implements BillsService {

    private final OrdersRepository ordersRepository;
    private final BillsRepository billsRepository;


    @Override
    public List<BillsEntity> getAllBills() {
        return billsRepository.findAll();
    }

    @Override
    public BillsEntity getBill(Long id) {
        return billsRepository.findById(id).orElse(null);
    }

    @Override
    public BillsEntity saveBill(BillsRequest request) {
        BillsEntity billsEntity = new BillsEntity();
        billsEntity.setTotalAmount(request.getTotalAmount());
        billsEntity.setStatus(request.getStatus());

        OrdersEntity orderId = ordersRepository
                .findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        billsEntity.setOrderId(orderId);

        return billsRepository.save(billsEntity);
    }

    @Override
    public BillsEntity updateBill(Long id, BillsRequest request) {
        BillsEntity billsEntity = billsRepository.findById(id).orElse(null);
        billsEntity.setTotalAmount(request.getTotalAmount());
        billsEntity.setStatus(request.getStatus());

        OrdersEntity orderId = ordersRepository
                .findById(request.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        billsEntity.setOrderId(orderId);

        return billsRepository.save(billsEntity);
    }

    @Override
    public void deleteBill(Long id) {
        billsRepository.deleteById(id);
    }
}
