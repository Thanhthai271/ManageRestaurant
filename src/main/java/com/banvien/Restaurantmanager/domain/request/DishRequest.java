package com.banvien.Restaurantmanager.domain.request;


import com.banvien.Restaurantmanager.domain.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishRequest {

    private Long id;
    private String name;
    private String description;
    private String price;
    private Long categoryId;
}
