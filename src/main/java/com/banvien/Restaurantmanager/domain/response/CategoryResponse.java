package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {
    private Long categoryId;
    private String categoryFood;
    private String categoryDrink;

    public CategoryResponse(){

    }

    public CategoryResponse(Long categoryId, String categoryFood, String categoryDrink){
        this.categoryId = categoryId;
        this.categoryFood = categoryFood;
        this.categoryDrink = categoryDrink;
    }
}
