package com.banvien.Restaurantmanager.Repository;

import com.banvien.Restaurantmanager.domain.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository <ReservationEntity, Long> {
}
