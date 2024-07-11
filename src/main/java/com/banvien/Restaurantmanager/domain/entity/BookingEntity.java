package com.banvien.Restaurantmanager.domain.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingId")
    private Long bookingId;

    @Column(name = "bookingDateTime")
    private LocalDateTime bookingDateTime;

    @Column(name = "numberOfGuest")
    private int numberOfGuest;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerEntity customerId;

    @ManyToOne
    @JoinColumn(name = "dinningTableId")
    private DinningTableEntity dinningTableId;

}
