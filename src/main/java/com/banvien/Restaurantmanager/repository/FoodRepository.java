package com.banvien.Restaurantmanager.repository;

import com.banvien.Restaurantmanager.domain.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {

}
