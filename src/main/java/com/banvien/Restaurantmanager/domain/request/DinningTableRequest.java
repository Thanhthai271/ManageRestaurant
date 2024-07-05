package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DinningTableRequest {

    private Long dinningTableId;
    private int tableNumber;
    private int seats;
}
