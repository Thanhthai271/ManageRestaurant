package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDrinksResponse {

    private Long orderDrinkId;
    private Long orderId;
    private Long drinkId;
    private int quanity, price;

    public OrderDrinksResponse(){

    }

    public OrderDrinksResponse(Long orderDrinkId, Long orderId, Long drinkId, int quanity, int price){
        this.orderDrinkId = orderDrinkId;
        this.orderId = orderId;
        this.drinkId = drinkId;
        this.quanity = quanity;
        this.price = price;
    }
}
