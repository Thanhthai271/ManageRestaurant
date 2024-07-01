package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.CustomerRespository;
import com.banvien.Restaurantmanager.Service.CustomerService;
import com.banvien.Restaurantmanager.domain.entity.CustomerEntity;
import com.banvien.Restaurantmanager.domain.request.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRespository customerRespository;

    @Override
    public List<CustomerEntity> getAllCus() {
        return customerRespository.findAll();
    }

    @Override
    public CustomerEntity getCus(Long id) {
        return customerRespository.findById(id).orElse(null);
    }

    @Override
    public CustomerEntity saveCus(CustomerRequest request) {
        CustomerEntity customer = new CustomerEntity();
        customer.setName(request.getName());
        customer.setPhonenumber(request.getPhoneNumber());
        customer.setEmail(request.getEmail());
        customer.setAddress(request.getAddress());
        return customerRespository.save(customer);
    }

    @Override
    public void deleteCus(Long id) {
        customerRespository.deleteById(id);
    }
}
