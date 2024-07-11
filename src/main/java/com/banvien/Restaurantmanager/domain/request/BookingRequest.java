package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingRequest {
    private Long bookingId;
    private LocalDateTime bookingDateTime;
    private int numberOfGuest;
    private Long customerId;
    private Long dinningTableId;
    private String status;
}
