package com.banvien.Restaurantmanager.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "Shifts")
public class ShiftsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShiftId")
    private Long ShiftId;

    @Column(name = "ShiftDate")
    private LocalDateTime ShiftDate;

    @Column(name = "startTime")
    private String startTime;

    @Column(name = "endTime")
    private String endTime;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeesEntity employees;

}
