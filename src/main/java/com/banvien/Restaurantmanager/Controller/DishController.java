package com.banvien.Restaurantmanager.Controller;


import com.banvien.Restaurantmanager.Service.DishService;
import com.banvien.Restaurantmanager.Service.Implement.DishServiceImpl;
import com.banvien.Restaurantmanager.domain.entity.DishEntity;
import com.banvien.Restaurantmanager.domain.request.DishRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    DishServiceImpl dishService;

    @GetMapping
    public List<DishEntity> getAllDish(){
        return dishService.getAllDish();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getDish(@PathVariable Long id){
        dishService.getDish(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save dish success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createDish(@RequestBody DishRequest request){
        dishService.saveDish(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save dish success")
                .build();
    }

    @PutMapping("/{id}")
    public GenericResponse<String> updateDish(@PathVariable Long id, @RequestBody DishRequest request){
        dishService.updateDish(id,request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save dish success")
                .build();
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteDish(@PathVariable Long id){
        dishService.deleteDish(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save dish success")
                .build();
    }
}
