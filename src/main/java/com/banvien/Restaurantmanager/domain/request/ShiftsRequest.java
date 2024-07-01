package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ShiftsRequest {
    private Long shiftId;
    private Long employeeId;
    private LocalDateTime shiftdate;
    private String starTime;
    private String endTime;
}
