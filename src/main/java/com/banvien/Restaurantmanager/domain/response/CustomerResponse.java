package com.banvien.Restaurantmanager.domain.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponse {
    private Long customerId;
    private String name,email,address;
    private String phoneNumber;

    public CustomerResponse(){

    }

    public CustomerResponse(String name, String email, String address, Long customerId, String phoneNumber){
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }
}
