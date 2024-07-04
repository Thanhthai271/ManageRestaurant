package com.banvien.Restaurantmanager.Controller;

import com.banvien.Restaurantmanager.Service.EmployeeShiftService;
import com.banvien.Restaurantmanager.domain.entity.EmployeeShiftEntity;
import com.banvien.Restaurantmanager.domain.request.EmployeeShiftRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeeshift")
public class EmployeeShiftController {

    @Autowired
    EmployeeShiftService employeeShiftService;

    @GetMapping
    public List<EmployeeShiftEntity> getAllEmployeeShift(){
        return employeeShiftService.getAllEmployeeShift();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getEmployeeShiftById(@PathVariable Long id){
        employeeShiftService.getEmployeeShift(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createEmployeeShift(@RequestBody EmployeeShiftRequest request){
       employeeShiftService.saveEmployeeShift(request);
       return GenericResponse.<String>builder()
               .success(Boolean.TRUE)
               .message("Success")
               .build();
    }

    @PutMapping
    public GenericResponse<String> updateEmployeeShift(@PathVariable Long id, @RequestBody EmployeeShiftRequest request){
        employeeShiftService.updateEmployeeShift(id, request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Success")
                .build();
    }

    @DeleteMapping
    public GenericResponse<String> deleteEmployeeShift(@PathVariable Long id){
        employeeShiftService.deleteEmployeeShift(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Success")
                .build();
    }

}
