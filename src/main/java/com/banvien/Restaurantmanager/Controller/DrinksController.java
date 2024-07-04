package com.banvien.Restaurantmanager.Controller;

import com.banvien.Restaurantmanager.Service.Implement.DrinksServiceImpl;
import com.banvien.Restaurantmanager.domain.entity.DrinksEntity;
import com.banvien.Restaurantmanager.domain.entity.TablesEntity;
import com.banvien.Restaurantmanager.domain.request.DrinksRequest;
import com.banvien.Restaurantmanager.domain.request.TablesRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinksController {

    @Autowired
    DrinksServiceImpl drinksService;

    @GetMapping
    public List<DrinksEntity> getAllDrinks(){
        return drinksService.getAllDrinks();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getDrink(@PathVariable Long id){
        drinksService.getDrink(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get drink success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createDrink(@RequestBody DrinksRequest request){
        drinksService.saveDrink(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Create drink succes")
                .build();
    }

    @PutMapping("/{id}")
    public GenericResponse<String> updateDrink(@PathVariable Long id, @RequestBody DrinksRequest request){
        drinksService.updateDrink(id,request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Update drink success")
                .build();
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteDrink(@PathVariable Long id){
        drinksService.deleteDrink(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete drink success")
                .build();
    }
}
