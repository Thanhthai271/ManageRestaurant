package com.banvien.Restaurantmanager.domain.response.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOOrder {
    private String foodName;
    private String price;
    private Integer quantity;
    private String employeeName;
    private String customerName;
    private Integer tableNumber;
    private String paymentStatus;

    public DTOOrder(String foodName,String price, Integer quantity, String employeeName, String customerName, Integer tableNumber, String paymentStatus){
        this.foodName = foodName;
        this.price = price;
        this.quantity = quantity;
        this.employeeName = employeeName;
        this.customerName = customerName;
        this.tableNumber = tableNumber;
        this.paymentStatus = paymentStatus;
    }
}
