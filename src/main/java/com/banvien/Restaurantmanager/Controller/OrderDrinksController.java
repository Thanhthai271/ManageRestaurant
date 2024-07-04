package com.banvien.Restaurantmanager.Controller;

import com.banvien.Restaurantmanager.Service.OrderDrinksService;
import com.banvien.Restaurantmanager.domain.entity.OrderDrinksEntity;
import com.banvien.Restaurantmanager.domain.request.OrderDrinksRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderdrinks")
public class OrderDrinksController {

    @Autowired
    OrderDrinksService orderDrinksService;

    @GetMapping
    public List<OrderDrinksEntity> getAllOrderDrinks(){
        return orderDrinksService.getAllOrderDrinks();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getOrderDrink(@PathVariable Long id){
        orderDrinksService.getOrderDrink(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get orderDrink success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createOrderDrink(@RequestBody OrderDrinksRequest request){
        orderDrinksService.saveOrderDrink(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Create orderDrink success")
                .build();
    }

    @PutMapping("/{id}")
    public GenericResponse<String> updateOrderDrink(@PathVariable Long id, @RequestBody OrderDrinksRequest request){
        orderDrinksService.updateOrderDrink(id,request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Update orderDrink success")
                .build();
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteOrderDetails(@PathVariable Long id){
        orderDrinksService.deleteOrderDrink(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete orderDrink success")
                .build();
    }
}
