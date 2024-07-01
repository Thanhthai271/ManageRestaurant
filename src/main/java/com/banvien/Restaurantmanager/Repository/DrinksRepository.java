package com.banvien.Restaurantmanager.Repository;

import com.banvien.Restaurantmanager.domain.entity.DrinksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinksRepository extends JpaRepository <DrinksEntity, Long> {

}
