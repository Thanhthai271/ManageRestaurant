package com.banvien.Restaurantmanager.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OrderDetails")
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderDetailId")
    private Long orderDetailId;

    @Column(name = "quanity")
    private int quanity;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrdersEntity order;

    @ManyToOne
    @JoinColumn(name = "dishId")
    private DishEntity dish;

    @ManyToOne
    @JoinColumn(name = "drinkId")
    private DrinksEntity drinks;
}
