package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeesRequest {

    private Long employeeId;
    private String name;
    private String position;
    private int phoneNumber;
    private String email;

}
