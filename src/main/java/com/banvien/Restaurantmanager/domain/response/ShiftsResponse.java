package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShiftsResponse {
    private Long shiftId;
    private String name;
    private String startTime;
    private String endTime;

    public ShiftsResponse(){

    }

    public ShiftsResponse(Long shiftId, String name, String startTime, String endTime){
        this.shiftId = shiftId;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
