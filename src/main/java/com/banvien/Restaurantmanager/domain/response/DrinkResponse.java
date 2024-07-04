package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrinkResponse {
    private Long drinkId, typeOfDrinkId;
    private String name;
    private String price;

    public DrinkResponse(){

    }

    public DrinkResponse(Long typeOfDrinkId, Long drinkId, String name, String price){
        this.drinkId = drinkId;
        this.name = name;
        this.price = price;
        this.typeOfDrinkId = typeOfDrinkId;
    }
}
