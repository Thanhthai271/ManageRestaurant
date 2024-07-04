package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.TypeOfDrinksRepository;
import com.banvien.Restaurantmanager.Service.TypeOfDrinksService;
import com.banvien.Restaurantmanager.domain.entity.TypeOfDrinksEntity;
import com.banvien.Restaurantmanager.domain.request.TypeOfDrinksRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfDrinksServiceImpl implements TypeOfDrinksService {

    @Autowired
    TypeOfDrinksRepository typeOfDrinksRepository;
    @Override
    public List<TypeOfDrinksEntity> getAllTypeOfDrinks() {
        return typeOfDrinksRepository.findAll();
    }

    @Override
    public TypeOfDrinksEntity getTypeOfDrink(Long id) {
        return typeOfDrinksRepository.findById(id).orElse(null);
    }

    @Override
    public TypeOfDrinksEntity saveTypeOfDrink(TypeOfDrinksRequest request) {
        TypeOfDrinksEntity typeOfDrinks = new TypeOfDrinksEntity();
        typeOfDrinks.setName(request.getName());
        return typeOfDrinksRepository.save(typeOfDrinks);
    }

    @Override
    public TypeOfDrinksEntity updateTypeOfDrink(Long id, TypeOfDrinksRequest request) {
        TypeOfDrinksEntity existingType = typeOfDrinksRepository.findById(id).orElse(null);
        existingType.setName(request.getName());
        return typeOfDrinksRepository.save(existingType);
    }

    @Override
    public void deleteTypeOfDrink(Long id) {
        typeOfDrinksRepository.deleteById(id);
    }
}
