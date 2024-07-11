package com.banvien.Restaurantmanager.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private long categoryId;

    @Column(name = "categoryFood")
    private String categoryFood;

    @Column(name = "categoryDrink")
    private String categoryDrink;
}
