package com.banvien.Restaurantmanager.controller;

import com.banvien.Restaurantmanager.service.EmployeesService;
import com.banvien.Restaurantmanager.domain.entity.EmployeesEntity;
import com.banvien.Restaurantmanager.domain.request.EmployeesRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeesController {

    @Autowired
    EmployeesService employeesService;

    @GetMapping
    public List<EmployeesEntity> getAllEmployee(){
        return employeesService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getEmployee(@PathVariable Long id){
        employeesService.getEmployee(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get employees success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createEmployee(@RequestBody EmployeesRequest request){
        employeesService.saveEmployee(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Create employees success")
                .build();
    }

    @PutMapping("/{id}")
    public GenericResponse<String> updateEmployee(@PathVariable Long id, @RequestBody EmployeesRequest request){
        employeesService.updateEmployee(id,request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Update employees success")
                .build();
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteEmployee(@PathVariable Long id){
        employeesService.deleteEmployee(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete employee success")
                .build();
    }
}
