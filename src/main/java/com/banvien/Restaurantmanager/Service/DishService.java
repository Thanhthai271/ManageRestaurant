package com.banvien.Restaurantmanager.Service;

import com.banvien.Restaurantmanager.domain.entity.DishEntity;
import com.banvien.Restaurantmanager.domain.request.DishRequest;
import com.banvien.Restaurantmanager.domain.response.DishResponse;

import java.util.List;

public interface DishService {
    List<DishEntity> getAllDish();
    DishEntity getDish(Long id);
    DishEntity saveDish(DishRequest request);
    void deleteDish(Long id);
}
