package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.DrinksRepository;
import com.banvien.Restaurantmanager.Repository.TypeOfDrinksRepository;
import com.banvien.Restaurantmanager.Service.DrinksService;
import com.banvien.Restaurantmanager.domain.entity.DrinksEntity;
import com.banvien.Restaurantmanager.domain.entity.TypeOfDrinksEntity;
import com.banvien.Restaurantmanager.domain.request.DrinksRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinksServiceImpl implements DrinksService {

  private final TypeOfDrinksRepository typeOfDrinksRepository;
  private final DrinksRepository drinksRepository;

    @Override
    public List<DrinksEntity> getAllDrinks() {
        return drinksRepository.findAll();
    }

    @Override
    public DrinksEntity getDrink(Long id) {
        return drinksRepository.findById(id).orElse(null);
    }

    @Override
    public DrinksEntity saveDrink(DrinksRequest request) {
        DrinksEntity drinks = new DrinksEntity();
        drinks.setName(request.getName());
        drinks.setPrice(request.getPrice());

        TypeOfDrinksEntity typeOfDrinksId = typeOfDrinksRepository
                .findById(request.getTypeOfDrinkId())
                .orElseThrow(() -> new RuntimeException("Type not found"));

        drinks.setTypeOfDrinkId(typeOfDrinksId);
        return drinksRepository.save(drinks);
    }

    @Override
    public DrinksEntity updateDrink(Long id, DrinksRequest request) {
        DrinksEntity existingDrink = drinksRepository.findById(id).orElse(null);
        existingDrink.setName(request.getName());
        existingDrink.setPrice(request.getPrice());

        TypeOfDrinksEntity typeOfDrinkIdEntity = typeOfDrinksRepository
                .findById(request.getTypeOfDrinkId())
                .orElseThrow(() -> new RuntimeException("Type not found"));

        existingDrink.setTypeOfDrinkId(typeOfDrinkIdEntity);
        return drinksRepository.save(existingDrink);
    }

    @Override
    public void deleteDrink(Long id) {
        drinksRepository.deleteById(id);
    }
}
