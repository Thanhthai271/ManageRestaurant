package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TablesResponse {
    private Long tableId;
    private int tableNumber,seats;

    public TablesResponse(){

    }

    public TablesResponse(Long tableId, int tableNumber, int seats){
        this.tableId = tableId;
        this.tableNumber = tableNumber;
        this.seats = seats;
    }
}
