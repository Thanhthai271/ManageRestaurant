package com.banvien.Restaurantmanager.domain.response;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderResponse {
    private Long orderId;
    private Long customerId;
    private Long bookingId;
    private LocalDateTime orderDateTime;
    private String status;

    public OrderResponse(){

    }

    public OrderResponse(String status, Long bookingId, Long orderId, Long customerId, LocalDateTime orderDateTime){
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDateTime = orderDateTime;
        this.bookingId = bookingId;
        this.status = status;
    }
}
