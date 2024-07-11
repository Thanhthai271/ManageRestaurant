package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrdersRequest {
    private Long customerId;
    private Long bookingId;
    private Long employeeId;
    private String status;
    private List<OrderDetailsRequest> orderDetails;
}
