package com.banvien.Restaurantmanager.domain.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodRequest {

    private Long foodId;
    private String name;
    private String description;
    private String price;
    private Long categoryId;
}
