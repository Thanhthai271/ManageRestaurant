package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TypeOfDrinksResponse {
    private Long typeOfDrinkId;
    private String name;

    public TypeOfDrinksResponse(){

    }

    public TypeOfDrinksResponse(Long typeOfDrinkId, String name){
        this.typeOfDrinkId = typeOfDrinkId;
        this.name = name;
    }
}
