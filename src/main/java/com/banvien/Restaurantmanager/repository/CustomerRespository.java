package com.banvien.Restaurantmanager.repository;

import com.banvien.Restaurantmanager.domain.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRespository extends JpaRepository <CustomerEntity, Long> {
}
