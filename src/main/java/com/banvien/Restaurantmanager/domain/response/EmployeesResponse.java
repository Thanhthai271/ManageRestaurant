package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeesResponse {
    private Long employeeId;
    private String name, position, email;
    private int phoneNumber;

    public EmployeesResponse(){

    }

    public EmployeesResponse(Long employeeId, String name, String position, String email, int phoneNumber){
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.email = email;
    }
}
