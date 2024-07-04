package com.banvien.Restaurantmanager.Service;

import com.banvien.Restaurantmanager.domain.entity.EmployeesEntity;
import com.banvien.Restaurantmanager.domain.request.EmployeesRequest;

import java.util.List;

public interface EmployeesService {
    List<EmployeesEntity> getAllEmployee();
    EmployeesEntity getEmployee(Long id);
    EmployeesEntity saveEmployee(EmployeesRequest request);
    EmployeesEntity updateEmployee(Long id, EmployeesRequest request);
    void deleteEmployee (Long id);
}
