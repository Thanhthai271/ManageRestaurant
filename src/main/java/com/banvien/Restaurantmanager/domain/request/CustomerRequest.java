package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {
    private Long customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
}
