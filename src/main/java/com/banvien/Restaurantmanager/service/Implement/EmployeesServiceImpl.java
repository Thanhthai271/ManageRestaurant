package com.banvien.Restaurantmanager.service.Implement;

import com.banvien.Restaurantmanager.domain.response.DTO.DTOEmployee;
import com.banvien.Restaurantmanager.repository.DTO.DTOEmployeeRepository;
import com.banvien.Restaurantmanager.repository.EmployeesRepository;
import com.banvien.Restaurantmanager.service.EmployeesService;
import com.banvien.Restaurantmanager.domain.entity.EmployeesEntity;
import com.banvien.Restaurantmanager.domain.request.EmployeesRequest;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    DTOEmployeeRepository dtoEmployeeRepository;

    @Override
    public List<DTOEmployee> getAllEmployeeShift() {
        List<Tuple> result = dtoEmployeeRepository.getAllEmployeeShift();
        return result.stream().map(tuple -> new DTOEmployee(
                tuple.get("employee_id", Long.class),
                tuple.get("name", String.class),
                tuple.get("position", String.class),
                tuple.get("day", String.class),
                tuple.get("start_time", String.class),
                tuple.get("end_time", String.class)
        )).collect(Collectors.toList());
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
