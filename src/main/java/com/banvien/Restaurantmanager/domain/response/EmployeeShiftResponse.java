package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeShiftResponse {

    private Long employeeShiftId;
    private String day;
    private Long shiftId;
    private Long employeeId;

    public EmployeeShiftResponse(){

    }

    public EmployeeShiftResponse(Long employeeShiftId, Long employeeId, Long shiftId, String day){
        this.employeeShiftId = employeeShiftId;
        this.employeeId = employeeId;
        this.shiftId = shiftId;
        this.day = day;
    }
}
