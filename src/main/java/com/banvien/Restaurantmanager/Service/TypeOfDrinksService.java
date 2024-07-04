package com.banvien.Restaurantmanager.Service;

import com.banvien.Restaurantmanager.domain.entity.TypeOfDrinksEntity;
import com.banvien.Restaurantmanager.domain.request.TypeOfDrinksRequest;

import java.util.List;

public interface TypeOfDrinksService {
    List<TypeOfDrinksEntity> getAllTypeOfDrinks();
    TypeOfDrinksEntity getTypeOfDrink(Long id);
    TypeOfDrinksEntity saveTypeOfDrink(TypeOfDrinksRequest request);
    TypeOfDrinksEntity updateTypeOfDrink(Long id, TypeOfDrinksRequest request);
    void deleteTypeOfDrink(Long id);
}
