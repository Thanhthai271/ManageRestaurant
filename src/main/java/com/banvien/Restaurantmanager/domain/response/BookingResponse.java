package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingResponse {
    private Long bookingId;
    private Long customerId;
    private Long dinningTableId;
    private LocalDateTime bookingDateTime;
    private int numberOfGuest;
    private String status;

    public BookingResponse(){

    }

    public BookingResponse(String status, Long bookingId, Long customerId, Long dinningTableId, LocalDateTime bookingDateTime, int numberOfGuest){
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.dinningTableId = dinningTableId;
        this.bookingDateTime = bookingDateTime;
        this.numberOfGuest = numberOfGuest;
        this.status = status;
    }
}
