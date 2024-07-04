package com.banvien.Restaurantmanager.Repository;

import com.banvien.Restaurantmanager.domain.entity.OrderDrinksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDrinksRepository extends JpaRepository<OrderDrinksEntity,Long> {
}
