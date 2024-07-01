package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationResponse {
    private Long reservationId, customerId, tableId;
    private LocalDateTime reservationDateTime;
    private int numberOfGuest;

    public ReservationResponse(){

    }

    public ReservationResponse(Long reservationId, Long customerId, Long tableId, LocalDateTime reservationDateTime, int numberOfGuest){
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.tableId = tableId;
        this.reservationDateTime = reservationDateTime;
        this.numberOfGuest = numberOfGuest;
    }
}
