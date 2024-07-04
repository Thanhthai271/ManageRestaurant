package com.banvien.Restaurantmanager.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Order Drinks Details")
public class OrderDrinksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderDrinksDetailId")
    private Long orderDrinksDetailId;

    @Column(name = "quanity")
    private int quanity;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrdersEntity orderId;

    @ManyToOne
    @JoinColumn(name = "drinkId")
    private DrinksEntity drinkId;
}
