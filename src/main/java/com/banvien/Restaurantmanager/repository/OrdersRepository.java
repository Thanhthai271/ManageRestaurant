package com.banvien.Restaurantmanager.repository;

import com.banvien.Restaurantmanager.domain.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {
}
