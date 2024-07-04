package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeShiftRequest {

    private Long employeeShiftId;
    private String day;
    private Long shiftId;
    private Long employeeId;
}
