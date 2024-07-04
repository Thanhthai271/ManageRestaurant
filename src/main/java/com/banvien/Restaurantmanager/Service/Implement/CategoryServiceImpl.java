package com.banvien.Restaurantmanager.Service.Implement;
import com.banvien.Restaurantmanager.Repository.CategoryRepository;
import com.banvien.Restaurantmanager.Service.CategoryService;
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
        category.setName(request.getName());

        return categoryRepository.save(category);
    }

    @Override
    public CategoryEntity updateCategory(Long id, CategoryRequest request) {
        CategoryEntity existingCategory = categoryRepository.findById(id).orElse(null);
        existingCategory.setName(request.getName());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}