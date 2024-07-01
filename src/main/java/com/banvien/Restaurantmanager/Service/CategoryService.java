package com.banvien.Restaurantmanager.Service;

import com.banvien.Restaurantmanager.domain.entity.CategoryEntity;
import com.banvien.Restaurantmanager.domain.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    List<CategoryEntity> getAllCategory();
    CategoryEntity getCategory(Long id);
    CategoryEntity saveCategory(CategoryRequest request);
    void deleteCategory(Long id);
}
