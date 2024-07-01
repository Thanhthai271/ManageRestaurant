package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShiftsResponse {
    private Long shiftId;
    private Long employeeId;
    private LocalDateTime shiftDate;
    private String startTime;
    private String endTime;

    public ShiftsResponse(){

    }

    public ShiftsResponse(Long shiftId, Long employeeId, LocalDateTime shiftDate, String startTime, String endTime){
        this.shiftId = shiftId;
        this.employeeId = employeeId;
        this.shiftDate = shiftDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
