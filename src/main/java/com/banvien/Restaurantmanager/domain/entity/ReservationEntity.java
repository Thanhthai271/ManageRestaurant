package com.banvien.Restaurantmanager.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Reservation")
public class             ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationId")
    private Long reservationId;

    @Column(name = "reservationDateTime")
    private LocalDateTime reservationDateTime;

    @Column(name = "numberOfGuest")
    private int numberOfGuest;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerEntity customerId;

    @ManyToOne
    @JoinColumn(name = "dinningTableId")
    private DinningTableEntity dinningTableId;

}
