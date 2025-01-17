package com.banvien.Restaurantmanager.repository;

import com.banvien.Restaurantmanager.domain.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findById(Long id);
}
