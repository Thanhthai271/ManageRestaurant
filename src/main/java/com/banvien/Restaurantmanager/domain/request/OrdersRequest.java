package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrdersRequest {
    private Long orderId;
    private LocalDateTime orderDateTime;
    private int totalAmount;
    private String status;
    private Long customerId;
    private Long tableId;
}
