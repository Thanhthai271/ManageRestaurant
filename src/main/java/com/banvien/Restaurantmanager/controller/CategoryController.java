package com.banvien.Restaurantmanager.controller;


import com.banvien.Restaurantmanager.service.Implement.CategoryServiceImpl;
import com.banvien.Restaurantmanager.domain.entity.CategoryEntity;
import com.banvien.Restaurantmanager.domain.request.CategoryRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping
    public List<CategoryEntity> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getCategoryFood(@PathVariable Long id){
        categoryService.getCategory(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save category success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createCategoryFood(@RequestBody CategoryRequest request){
        categoryService.saveCategory(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save category success")
                .build();
    }

    @PutMapping("/{id}")
    public GenericResponse<String> updateCategoryFood(@PathVariable Long id, @RequestBody CategoryRequest request){
        categoryService.updateCategory(id,request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save category success")
                .build();
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save category success")
                .build();
    }
}
