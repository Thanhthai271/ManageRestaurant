package com.banvien.Restaurantmanager.service;

import com.banvien.Restaurantmanager.domain.entity.EmployeesEntity;
import com.banvien.Restaurantmanager.domain.request.EmployeesRequest;
import com.banvien.Restaurantmanager.domain.response.DTO.DTOEmployee;

import java.util.List;

public interface EmployeesService {
    public List<DTOEmployee> getAllEmployeeShift();
    EmployeesEntity getEmployee(Long id);
    EmployeesEntity saveEmployee(EmployeesRequest request);
    EmployeesEntity updateEmployee(Long id, EmployeesRequest request);
    void deleteEmployee (Long id);
}
