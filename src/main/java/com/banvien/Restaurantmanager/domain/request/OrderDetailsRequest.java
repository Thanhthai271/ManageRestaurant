package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsRequest {
    private Long orderDetailId;
    private Long orderId;
    private Long dishId;
    private int quanity;
    private int price;
}
