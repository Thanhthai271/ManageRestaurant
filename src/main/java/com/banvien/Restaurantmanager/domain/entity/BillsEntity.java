package com.banvien.Restaurantmanager.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Bill")
public class BillsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill Id")
    private Long billId;

    @Column(name = "totalAmount")
    private String totalAmount;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private OrdersEntity orderId;
}
