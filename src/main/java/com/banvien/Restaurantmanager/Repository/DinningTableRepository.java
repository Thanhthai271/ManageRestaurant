package com.banvien.Restaurantmanager.Repository;

import com.banvien.Restaurantmanager.domain.entity.DinningTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DinningTableRepository extends JpaRepository<DinningTableEntity, Long> {
}
