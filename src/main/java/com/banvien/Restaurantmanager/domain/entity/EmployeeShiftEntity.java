package com.banvien.Restaurantmanager.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "EmployeeShift")
public class EmployeeShiftEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeShiftId")
    private Long employeeShiftId;

    @Column(name = "Day")
    private String day;

    @ManyToOne
    @JoinColumn(name = "ShiftId")
    private ShiftsEntity shiftId;

    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    private EmployeesEntity employeeId;
}
