package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsResponse {

    private Long orderDetailId,employeeId,orderDrinkId;
    private Long orderId;
    private Long dishId;
    private int quanity, price;

    public OrderDetailsResponse(){

    }

    public OrderDetailsResponse(Long employeeId,Long orderDrinkId, Long orderDetailId, Long orderId, Long dishId, int quanity, int price){
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.dishId = dishId;
        this.quanity = quanity;
        this.price = price;
        this.orderDrinkId = orderDrinkId;
        this.employeeId = employeeId;
    }
}
