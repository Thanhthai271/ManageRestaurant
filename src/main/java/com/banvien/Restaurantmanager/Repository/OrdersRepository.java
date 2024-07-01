package com.banvien.Restaurantmanager.Repository;

import com.banvien.Restaurantmanager.domain.entity.OrdersEntity;
import com.banvien.Restaurantmanager.domain.request.OrdersRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {
}
