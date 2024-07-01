package com.banvien.Restaurantmanager.domain.response;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderResponse {
    private Long orderId, customerId, tableId;
    private LocalDateTime orderDateTime;
    private int totalAmount;
    private String status;

    public OrderResponse(){

    }

    public OrderResponse(Long orderId, Long customerId, Long tableId, LocalDateTime orderDateTime, int totalAmount, String status){
        this.orderId = orderId;
        this.customerId = customerId;
        this.tableId = tableId;
        this.orderDateTime = orderDateTime;
        this.totalAmount = totalAmount;
        this.status = status;
    }
}
