package com.banvien.Restaurantmanager.service.Implement;

import com.banvien.Restaurantmanager.repository.CategoryRepository;
import com.banvien.Restaurantmanager.repository.FoodRepository;
import com.banvien.Restaurantmanager.repository.MenuRepository;
import com.banvien.Restaurantmanager.service.FoodService;
import com.banvien.Restaurantmanager.domain.entity.CategoryEntity;
import com.banvien.Restaurantmanager.domain.entity.FoodEntity;
import com.banvien.Restaurantmanager.domain.request.FoodRequest;
import com.banvien.Restaurantmanager.domain.response.DTO.DTOMenu;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository dishRepository;
    private final CategoryRepository categoryFoodRepository;
    private final MenuRepository menuRepository;

    public List<DTOMenu> getAllMenu(){
        List<Tuple> result = menuRepository.GetAllMenu();
        return result.stream().map(tuple -> new DTOMenu(
                tuple.get("name", String.class),
                tuple.get("description", String.class),
                tuple.get("price", String.class),
                tuple.get("category_food", String.class),
                tuple.get("category_drink", String.class)
        )).collect(Collectors.toList());
    }

    @Override
    public List<FoodEntity> getAllFoods() {
        return dishRepository.findAll();
    }

    @Override
    public FoodEntity getFood(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    public FoodEntity saveFood(FoodRequest request) {
        FoodEntity dishEntity = new FoodEntity();
        dishEntity.setName(request.getName());
        dishEntity.setDescription(request.getDescription());
        dishEntity.setPrice(request.getPrice());

        CategoryEntity categoryFoodId = categoryFoodRepository
                .findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        dishEntity.setCategoryId(categoryFoodId);
        return dishRepository.save(dishEntity);
    }

    @Override
    public FoodEntity updateFood(Long id, FoodRequest request) {
        FoodEntity existingDish = dishRepository.findById(id).orElse(null);
        existingDish.setName(request.getName());
        existingDish.setDescription(request.getDescription());
        existingDish.setPrice(request.getPrice());

        CategoryEntity categoryFoodId = categoryFoodRepository
                .findById(request.getCategoryId())
                        .orElseThrow(() -> new RuntimeException("Category not found"));
        existingDish.setCategoryId(categoryFoodId);
        return dishRepository.save(existingDish);
    }

    @Override
    public void deleteFood(Long id) {
        dishRepository.deleteById(id);
    }
}


