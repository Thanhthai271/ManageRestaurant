package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationResponse {
    private Long reservationId, customerId, dinningTableId;
    private LocalDateTime reservationDateTime;
    private int numberOfGuest;

    public ReservationResponse(){

    }

    public ReservationResponse(Long reservationId, Long customerId, Long dinningTableId, LocalDateTime reservationDateTime, int numberOfGuest){
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.dinningTableId = dinningTableId;
        this.reservationDateTime = reservationDateTime;
        this.numberOfGuest = numberOfGuest;
    }
}
