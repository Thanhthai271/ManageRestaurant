package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.DrinksRepository;
import com.banvien.Restaurantmanager.Service.DrinksService;
import com.banvien.Restaurantmanager.domain.entity.DrinksEntity;
import com.banvien.Restaurantmanager.domain.request.DrinksRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinksServiceImpl implements DrinksService {

    @Autowired
    DrinksRepository drinksRepository;

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
        return drinksRepository.save(drinks);
    }

    @Override
    public void deleteDrink(Long id) {
        drinksRepository.deleteById(id);
    }
}
