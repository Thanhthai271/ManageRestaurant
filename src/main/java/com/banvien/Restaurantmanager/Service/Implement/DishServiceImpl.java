package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Controller.DishController;
import com.banvien.Restaurantmanager.Repository.CategoryRepository;
import com.banvien.Restaurantmanager.Repository.DishRepository;
import com.banvien.Restaurantmanager.Service.DishService;
import com.banvien.Restaurantmanager.domain.entity.CategoryEntity;
import com.banvien.Restaurantmanager.domain.entity.DishEntity;
import com.banvien.Restaurantmanager.domain.request.DishRequest;
import com.banvien.Restaurantmanager.domain.response.DishResponse;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<DishEntity> getAllDish() {
        return dishRepository.findAll();
    }

    @Override
    public DishEntity getDish(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    public DishEntity saveDish(DishRequest request) {
        DishEntity dishEntity = new DishEntity();
        dishEntity.setName(request.getName());
        dishEntity.setDescription(request.getDescription());
        dishEntity.setPrice(request.getPrice());

        CategoryEntity categoryEntity = categoryRepository
                .findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        dishEntity.setCategory(categoryEntity);
        return dishRepository.save(dishEntity);
    }

    @Override
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}


