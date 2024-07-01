package com.banvien.Restaurantmanager.domain.response;


import com.banvien.Restaurantmanager.domain.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DishResponse {
    private Long id;
    private String name;
    private String description;
    private String price;
    private CategoryEntity category;

    public DishResponse(){

    }

    public DishResponse(Long id, String name, String description, String price, CategoryEntity category){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}
