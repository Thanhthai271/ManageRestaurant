package com.banvien.Restaurantmanager.repository;

import com.banvien.Restaurantmanager.domain.entity.BillsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillsRepository extends JpaRepository<BillsEntity, Long> {
}
