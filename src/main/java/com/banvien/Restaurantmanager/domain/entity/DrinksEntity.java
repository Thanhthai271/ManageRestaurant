package com.banvien.Restaurantmanager.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Drinks")
public class DrinksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drinkId")
    private Long drinkId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @ManyToOne
    @JoinColumn(name = "typeOfDrinkId")
    private TypeOfDrinksEntity typeOfDrinkId;
}
