package com.banvien.Restaurantmanager.Controller;

import com.banvien.Restaurantmanager.Service.Implement.TypeOfDrinksServiceImpl;
import com.banvien.Restaurantmanager.domain.entity.TypeOfDrinksEntity;
import com.banvien.Restaurantmanager.domain.request.TypeOfDrinksRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeofdrink")
public class TypeOfDrinksController {

    @Autowired
    TypeOfDrinksServiceImpl typeOfDrinksService;

    @GetMapping
    public List<TypeOfDrinksEntity> getAllType(){
       return typeOfDrinksService.getAllTypeOfDrinks();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getType(@PathVariable Long id){
        typeOfDrinksService.getTypeOfDrink(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get type success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createType(@RequestBody TypeOfDrinksRequest request){
        typeOfDrinksService.saveTypeOfDrink(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save type success")
                .build();
    }

    @PutMapping("/{id}")
    public GenericResponse<String> updateType(@PathVariable Long id,@RequestBody TypeOfDrinksRequest request){
        typeOfDrinksService.updateTypeOfDrink(id,request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("update type success")
                .build();
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteType(@PathVariable Long id){
        typeOfDrinksService.deleteTypeOfDrink(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete type success")
                .build();
    }
}
