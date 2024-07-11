package com.banvien.Restaurantmanager.service;

import com.banvien.Restaurantmanager.domain.entity.FoodEntity;
import com.banvien.Restaurantmanager.domain.request.FoodRequest;

import java.util.List;

public interface FoodService {
    List<FoodEntity> getAllFoods();
    FoodEntity getFood(Long id);
    FoodEntity saveFood(FoodRequest request);
    FoodEntity updateFood(Long id, FoodRequest request);
    void deleteFood(Long id);
}
