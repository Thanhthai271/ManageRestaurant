package com.banvien.Restaurantmanager.domain.response;


import com.banvien.Restaurantmanager.domain.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodResponse {
    private Long foodId;
    private String name;
    private String description;
    private String price;
    private Long categoryId;

    public FoodResponse(){

    }

    public FoodResponse(Long foodId, String name, String description, String price, Long categoryId){
        this.foodId = foodId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
    }
}
