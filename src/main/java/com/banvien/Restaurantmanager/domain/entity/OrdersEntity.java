package com.banvien.Restaurantmanager.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "orderDateTime")
    private LocalDateTime orderDateTime;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerEntity customerId;

    @ManyToOne
    @JoinColumn(name = "dinningTableId")
    private DinningTableEntity dinningTableId;
}
