package com.banvien.Restaurantmanager.Repository;

import com.banvien.Restaurantmanager.domain.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long> {
}
