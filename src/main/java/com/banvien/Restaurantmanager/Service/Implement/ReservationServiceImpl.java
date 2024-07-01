package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.ReservationRepository;
import com.banvien.Restaurantmanager.Service.ReservationService;
import com.banvien.Restaurantmanager.domain.entity.ReservationEntity;
import com.banvien.Restaurantmanager.domain.request.ReservationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public List<ReservationEntity> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public ReservationEntity getReservation(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public ReservationEntity saveReservation(ReservationRequest request) {
        ReservationEntity reservation = new ReservationEntity();
        reservation.setReservationDateTime(request.getReservationDateTime());
        reservation.setNumberOfGuest(request.getNumberOfGuest());
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
