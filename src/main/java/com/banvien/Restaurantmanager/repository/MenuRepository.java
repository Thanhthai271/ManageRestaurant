package com.banvien.Restaurantmanager.repository;

import com.banvien.Restaurantmanager.domain.entity.FoodEntity;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<FoodEntity, Long> {
    @Query(value = "SELECT f.name, f.description, f.price, c.category_food, c.category_drink " +
            "FROM food f LEFT JOIN category c ON f.category_id = c.category_id",
    nativeQuery = true)
    List<Tuple> GetAllMenu();
}
