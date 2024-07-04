package com.banvien.Restaurantmanager.Service;

import com.banvien.Restaurantmanager.domain.entity.ReservationEntity;
import com.banvien.Restaurantmanager.domain.request.ReservationRequest;

import java.util.List;

public interface ReservationService {
    List<ReservationEntity> getAllReservation();
    ReservationEntity getReservation(Long id);
    ReservationEntity saveReservation(ReservationRequest request);
    ReservationEntity updateReservation(Long id, ReservationRequest request);
    void deleteReservation(Long id);
}
