package com.banvien.Restaurantmanager.Service;

import com.banvien.Restaurantmanager.domain.entity.CustomerEntity;
import com.banvien.Restaurantmanager.domain.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> getAllCus();
    CustomerEntity getCus(Long id);
    CustomerEntity saveCus(CustomerRequest request);
    CustomerEntity updateCus(Long id, CustomerRequest request);
    void deleteCus(Long id);
}
