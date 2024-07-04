package com.banvien.Restaurantmanager.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Type Of Drinks")
public class TypeOfDrinksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeOfDrinkId")
    private Long typeOfDrinkId;

    @Column(name = "name")
    private String name;
}
