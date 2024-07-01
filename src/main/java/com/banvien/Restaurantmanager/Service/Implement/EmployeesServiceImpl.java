package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.EmployeesRepository;
import com.banvien.Restaurantmanager.Service.EmployeesService;
import com.banvien.Restaurantmanager.domain.entity.EmployeesEntity;
import com.banvien.Restaurantmanager.domain.request.EmployeesRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;

    @Override
    public List<EmployeesEntity> getAllEmployee() {
        return employeesRepository.findAll();
    }

    @Override
    public EmployeesEntity getEmployee(Long id) {
        return employeesRepository.findById(id).orElse(null);
    }

    @Override
    public EmployeesEntity saveEmployee(EmployeesRequest request) {
        EmployeesEntity employees = new EmployeesEntity();
        employees.setName(request.getName());
        employees.setEmail(request.getEmail());
        employees.setPhoneNumber(request.getPhoneNumber());
        employees.setPosition(request.getPosition());
        return employeesRepository.save(employees);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeesRepository.deleteById(id);
    }
}
