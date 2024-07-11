package com.banvien.Restaurantmanager.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DinningTableResponse {
    private Long dinningTableId;
    private Integer tableNumber;
    private Integer seats;
    private String status;

//    public DinningTableResponse(){
//
//    }

    public DinningTableResponse(Integer seats, Integer tableNumber, Long dinningTableId, String status){
        this.dinningTableId = dinningTableId;
        this.tableNumber = tableNumber;
        this.seats = seats;
        this.status = status;
    }
}
