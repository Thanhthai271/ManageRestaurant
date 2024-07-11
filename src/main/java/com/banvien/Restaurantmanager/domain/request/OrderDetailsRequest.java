package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDetailsRequest {
    private Long orderDetailId,employeeId;
    private Long orderId;
    private Long foodId;
    private Integer quantity;
    private int price;
}
