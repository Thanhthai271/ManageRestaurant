package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDrinksRequest {
    private Long orderDrinkId;
    private Long orderId;
    private Long drinkId;
    private int quanity;
    private int price;
}
