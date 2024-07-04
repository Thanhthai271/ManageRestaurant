package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrinksRequest {
    private Long drinkId, typeOfDrinkId;
    private String name;
    private String price;
}
