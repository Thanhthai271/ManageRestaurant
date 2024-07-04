package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillsRequest {

    private Long billId,orderId;
    private String totalAmount,status;
}
