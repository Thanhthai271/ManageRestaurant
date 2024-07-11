package com.banvien.Restaurantmanager.service.Implement;
import com.banvien.Restaurantmanager.repository.CategoryRepository;
import com.banvien.Restaurantmanager.service.CategoryService;
import com.banvien.Restaurantmanager.domain.entity.CategoryEntity;
import com.banvien.Restaurantmanager.domain.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity getCategory(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryEntity saveCategory(CategoryRequest request) {

        CategoryEntity category = new CategoryEntity();
        category.setCategoryFood(request.getCategoryFood());
        category.setCategoryDrink(request.getCategoryDrink());

        return categoryRepository.save(category);
    }

    @Override
    public CategoryEntity updateCategory(Long id, CategoryRequest request) {
        CategoryEntity existingCategory = categoryRepository.findById(id).orElse(null);
        existingCategory.setCategoryFood(request.getCategoryFood());
        existingCategory.setCategoryDrink(request.getCategoryDrink());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}