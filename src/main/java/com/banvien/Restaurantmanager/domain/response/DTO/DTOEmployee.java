package com.banvien.Restaurantmanager.domain.response.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOEmployee {
    private Long employeeId;
    private String name;
    private String position;
    private String day;
    private String startTime;
    private String endTime;

    public DTOEmployee(Long employeeId, String name, String position, String day, String startTime, String endTime){
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
