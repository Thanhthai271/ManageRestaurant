package com.banvien.Restaurantmanager.Controller;


import com.banvien.Restaurantmanager.Service.Implement.CategoryServiceImpl;
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
    public GenericResponse<String> getCategory(@PathVariable Long id){
        categoryService.getCategory(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save category success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createCategory(@RequestBody CategoryRequest request){
        categoryService.saveCategory(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save category success")
                .build();
    }

    @PutMapping
    public GenericResponse<String> updateCategory(@RequestParam Long id, @RequestBody CategoryRequest request){
        request.setId(id);
        categoryService.saveCategory(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save category success")
                .build();
    }

    @DeleteMapping
    public GenericResponse<String> deleteCategory(Long id){
        categoryService.deleteCategory(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save category success")
                .build();
    }
}
