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
    private OrdersEntity orderId;

    @ManyToOne
    @JoinColumn(name = "dishId")
    private DishEntity dishId;

    @ManyToOne
    @JoinColumn(name = "orderdrinkId")
    private OrderDrinksEntity orderDrinkId;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private EmployeesEntity employeeId;
}
