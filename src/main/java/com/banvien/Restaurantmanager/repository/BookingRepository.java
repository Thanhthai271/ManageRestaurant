package com.banvien.Restaurantmanager.repository;

import com.banvien.Restaurantmanager.domain.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository <BookingEntity, Long> {
}
