package com.banvien.Restaurantmanager.Controller;

import com.banvien.Restaurantmanager.Service.BillsService;
import com.banvien.Restaurantmanager.domain.entity.BillsEntity;
import com.banvien.Restaurantmanager.domain.request.BillsRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillsController {

    @Autowired
    BillsService billsService;

    @GetMapping
    public List<BillsEntity> getAllBills(){
        return billsService.getAllBills();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> createBill(@PathVariable Long id){
        billsService.getBill(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get bill success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createBill(@RequestBody BillsRequest request){
        billsService.saveBill(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save bill success")
                .build();
    }

    @PutMapping("/{id}")
    public GenericResponse<String> updateBill(@PathVariable Long id, @RequestBody BillsRequest request){
        billsService.updateBill(id,request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Update bill success")
                .build();
    }

    @DeleteMapping
    public GenericResponse<String> deleteBill(Long id){
        billsService.deleteBill(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete bill success")
                .build();
    }
}
