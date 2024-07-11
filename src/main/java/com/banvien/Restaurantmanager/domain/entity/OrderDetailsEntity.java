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
    private Long orderDetail;

    @Column(name = "quanity")
    private int quanity;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrdersEntity order;

    @ManyToOne
    @JoinColumn(name = "foodId")
    private FoodEntity food;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private EmployeesEntity employee;
}
