package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {
    private Long id;
    private String name;

    public CategoryResponse(){

    }

    public CategoryResponse(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
