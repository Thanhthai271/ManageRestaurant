package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationRequest {
    private Long reservationId;
    private LocalDateTime reservationDateTime;
    private int numberOfGuest;
    private Long customerId;
    private Long tableId;
}
