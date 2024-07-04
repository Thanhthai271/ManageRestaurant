package com.banvien.Restaurantmanager.Service;

import com.banvien.Restaurantmanager.domain.entity.DrinksEntity;
import com.banvien.Restaurantmanager.domain.request.DrinksRequest;

import java.util.List;

public interface DrinksService {
    List<DrinksEntity> getAllDrinks();
    DrinksEntity getDrink(Long id);
    DrinksEntity saveDrink(DrinksRequest request);
    DrinksEntity updateDrink(Long id, DrinksRequest request);
    void deleteDrink(Long id);
}
