package com.banvien.Restaurantmanager.service;

import com.banvien.Restaurantmanager.domain.entity.EmployeeShiftEntity;
import com.banvien.Restaurantmanager.domain.request.EmployeeShiftRequest;

import java.util.List;

public interface EmployeeShiftService {
    List<EmployeeShiftEntity> getAllEmployeeShift();
    EmployeeShiftEntity getEmployeeShift(Long id);
    EmployeeShiftEntity saveEmployeeShift(EmployeeShiftRequest request);
    EmployeeShiftEntity updateEmployeeShift(Long id, EmployeeShiftRequest request);
    void deleteEmployeeShift(Long id);
}
