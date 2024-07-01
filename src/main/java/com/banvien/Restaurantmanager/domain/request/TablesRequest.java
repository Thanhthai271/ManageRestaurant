package com.banvien.Restaurantmanager.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TablesRequest {

    private Long tableId;
    private int tableNumber;
    private int seats;
}
