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

    @Column(name = "payment_Status")
    private String paymentStatus;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "bookingId")
    private BookingEntity booking;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private EmployeesEntity employee;
}
