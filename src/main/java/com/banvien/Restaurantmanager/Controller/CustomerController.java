package com.banvien.Restaurantmanager.Controller;

import com.banvien.Restaurantmanager.Service.CustomerService;
import com.banvien.Restaurantmanager.domain.entity.CustomerEntity;
import com.banvien.Restaurantmanager.domain.request.CustomerRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<CustomerEntity> getAllCus(){
       return customerService.getAllCus();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getCus(@PathVariable Long id){
        customerService.getCus(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get cus success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createCus(@RequestBody CustomerRequest request){
        customerService.saveCus(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Create cus succes")
                .build();
    }

    @PutMapping
    public GenericResponse<String> updateCus(@RequestParam Long id, @RequestBody CustomerRequest request){
        request.setCustomerId(id);
        customerService.saveCus(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Update cus success")
                .build();
    }

    @DeleteMapping
    public GenericResponse<String> deleteCus(Long id){
        customerService.deleteCus(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete cus success")
                .build();
    }
}
