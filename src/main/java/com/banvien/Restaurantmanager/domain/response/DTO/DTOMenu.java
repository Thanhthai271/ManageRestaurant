package com.banvien.Restaurantmanager.domain.response.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOMenu {
    private String name;
    private String description;
    private String price;
    private String categoryFood;
    private String categoryDrink;

    public DTOMenu(String name, String description, String price, String categoryFood, String categoryDrink){
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryFood = categoryFood;
        this.categoryDrink = categoryDrink;
    }
}
