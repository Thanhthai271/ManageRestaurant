package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DinningTableResponse {
    private Long dinningTableId;
    private int tableNumber,seats;

    public DinningTableResponse(){

    }

    public DinningTableResponse(Long dinningTableId, int tableNumber, int seats){
        this.dinningTableId = dinningTableId;
        this.tableNumber = tableNumber;
        this.seats = seats;
    }
}
