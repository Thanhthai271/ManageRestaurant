package com.banvien.Restaurantmanager.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Tables")
public class DinningTableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dinningtableId")
    private Long dinningTableId;

    @Column(name = "tableNumber")
    private int tableNumber;

    @Column(name = "seats")
    private int seats;
}
