package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.EmployeesRepository;
import com.banvien.Restaurantmanager.Service.EmployeesService;
import com.banvien.Restaurantmanager.domain.entity.EmployeesEntity;
import com.banvien.Restaurantmanager.domain.request.EmployeesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public EmployeesEntity updateEmployee(Long id, EmployeesRequest request) {
        EmployeesEntity existingEmployee = employeesRepository.findById(id).orElse(null);
        existingEmployee.setName(request.getName());
        existingEmployee.setPhoneNumber(request.getPhoneNumber());
        existingEmployee.setPosition(request.getPosition());
        existingEmployee.setEmail(request.getEmail());
        return employeesRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeesRepository.deleteById(id);
    }
}
