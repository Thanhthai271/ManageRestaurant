package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillsResponse {

    private Long billId,orderId;
    private String totalAmount,status;

    public BillsResponse(){

    }

    public BillsResponse(Long billId, Long orderId, String totalAmount, String status){
        this.billId = billId;
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.status = status;
    }
}
