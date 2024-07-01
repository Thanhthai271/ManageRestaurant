package com.banvien.Restaurantmanager.Controller;


import com.banvien.Restaurantmanager.Service.OrderDetailsService;
import com.banvien.Restaurantmanager.domain.entity.OrderDetailsEntity;
import com.banvien.Restaurantmanager.domain.request.OrderDetailsRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdetails")
public class OdersDetailsController {

    @Autowired
    OrderDetailsService orderDetailsService;

    @GetMapping
    public List<OrderDetailsEntity> getAllOrderDetail(){
        return orderDetailsService.getAllOrderDetails();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getOrderDetails(@PathVariable Long id){
        orderDetailsService.getOrderDetail(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get orderDetails success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createOrderDetails(@RequestBody OrderDetailsRequest request){
        orderDetailsService.saveOrderDetail(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Create orderDetails success")
                .build();
    }

    @PutMapping
    public GenericResponse<String> updateOrderDetails(@PathVariable Long id, @RequestBody OrderDetailsRequest request){
        request.setOrderDetailId(id);
        orderDetailsService.saveOrderDetail(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Update orderDetails success")
                .build();
    }

    @DeleteMapping
    public GenericResponse<String> deleteOrderDetails(@PathVariable Long id){
        orderDetailsService.deleteOrderDetail(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete orderDetails succes")
                .build();
    }
}
