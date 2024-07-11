package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsResponse {

    private Long orderDetailId,employeeId;
    private Long orderId;
    private Long foodId;
    private int quanity, price;

    public OrderDetailsResponse(){

    }

    public OrderDetailsResponse(Long employeeId, Long orderDetailId, Long orderId, Long foodId, int quanity, int price){
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.foodId = foodId;
        this.quanity = quanity;
        this.price = price;
        this.employeeId = employeeId;
    }
}
