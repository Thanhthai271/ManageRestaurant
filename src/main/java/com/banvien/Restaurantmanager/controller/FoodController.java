package com.banvien.Restaurantmanager.controller;


import com.banvien.Restaurantmanager.service.Implement.FoodServiceImpl;
import com.banvien.Restaurantmanager.domain.request.FoodRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import com.banvien.Restaurantmanager.domain.response.DTO.DTOMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodServiceImpl foodService;

    @GetMapping
    public List<DTOMenu> getAllFoods(){
        return foodService.getAllMenu();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getDish(@PathVariable Long id){
        foodService.getFood(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save dish success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createDish(@RequestBody FoodRequest request){
        foodService.saveFood(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save dish success")
                .build();
    }

    @PutMapping("/{id}")
    public GenericResponse<String> updateDish(@PathVariable Long id, @RequestBody FoodRequest request){
        foodService.updateFood(id,request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save dish success")
                .build();
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteDish(@PathVariable Long id){
        foodService.deleteFood(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save dish success")
                .build();
    }
}
