package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.CustomerRespository;
import com.banvien.Restaurantmanager.Repository.ReservationRepository;
import com.banvien.Restaurantmanager.Repository.DinningTableRepository;
import com.banvien.Restaurantmanager.Service.ReservationService;
import com.banvien.Restaurantmanager.domain.entity.CustomerEntity;
import com.banvien.Restaurantmanager.domain.entity.ReservationEntity;
import com.banvien.Restaurantmanager.domain.entity.DinningTableEntity;
import com.banvien.Restaurantmanager.domain.request.ReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final DinningTableRepository tablesRepository;
    private final CustomerRespository customerRespository;

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

        DinningTableEntity tablesIdEntity = tablesRepository
                .findById(request.getDinningTableId())
                .orElseThrow(() -> new RuntimeException("Table not found"));

        CustomerEntity customerIdEntity = customerRespository
                .findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        reservation.setCustomerId(customerIdEntity);
        reservation.setDinningTableId(tablesIdEntity);

        return reservationRepository.save(reservation);
    }

    @Override
    public ReservationEntity updateReservation(Long id, ReservationRequest request) {
        ReservationEntity existingReservation = reservationRepository.findById(id).orElse(null);
        existingReservation.setReservationDateTime(request.getReservationDateTime());
        existingReservation.setNumberOfGuest(request.getNumberOfGuest());

        DinningTableEntity tablesIdEntity = tablesRepository
                .findById(request.getDinningTableId())
                .orElseThrow(() -> new RuntimeException("Table not found"));

        CustomerEntity customerIdEntity = customerRespository
                .findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        existingReservation.setDinningTableId(tablesIdEntity);
        existingReservation.setCustomerId(customerIdEntity);

        return reservationRepository.save(existingReservation);
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
