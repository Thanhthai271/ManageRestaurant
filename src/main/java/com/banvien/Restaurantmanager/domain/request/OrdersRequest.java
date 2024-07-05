package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrdersRequest {
    private Long orderId;
    private LocalDateTime orderDateTime;
    private Long customerId;
    private Long dinningTableId;
}
