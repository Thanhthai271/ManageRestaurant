package com.banvien.Restaurantmanager.service;

import com.banvien.Restaurantmanager.domain.entity.BillsEntity;
import com.banvien.Restaurantmanager.domain.request.BillsRequest;

import java.util.List;

public interface BillsService {
    List<BillsEntity> getAllBills();
    BillsEntity getBill(Long id);
    BillsEntity saveBill(BillsRequest request);
    BillsEntity updateBill(Long id, BillsRequest request);
    void deleteBill(Long id);
}
