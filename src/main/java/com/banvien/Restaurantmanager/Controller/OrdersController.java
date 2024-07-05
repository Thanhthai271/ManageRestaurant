package com.banvien.Restaurantmanager.Controller;

import com.banvien.Restaurantmanager.Service.OrdersService;
import com.banvien.Restaurantmanager.domain.entity.OrdersEntity;
import com.banvien.Restaurantmanager.domain.request.OrdersRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @GetMapping
    public List<OrdersEntity> getAllOrder(){
        return ordersService.getAllEntity();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getOrder(@PathVariable Long id){
        ordersService.getOrder(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get order success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createOrder(@RequestBody OrdersRequest request){
        ordersService.saveOrder(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Create order success")
                .build();
    }

    @PutMapping("/{id}")
    public GenericResponse<String> updateOrder(@PathVariable Long id, @RequestBody OrdersRequest request){
        ordersService.updateOrder(id,request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Create order success")
                .build();
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteOrder(@PathVariable Long id){
        ordersService.deleteOrder(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete order success")
                .build();
    }
}
