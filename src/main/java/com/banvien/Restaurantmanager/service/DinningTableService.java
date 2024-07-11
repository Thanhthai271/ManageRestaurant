package com.banvien.Restaurantmanager.service;

import com.banvien.Restaurantmanager.domain.entity.DinningTableEntity;
import com.banvien.Restaurantmanager.domain.request.DinningTableRequest;

import java.util.List;

public interface DinningTableService {
    List<DinningTableEntity> getAllTables();
    DinningTableEntity getTable(Long id);
    DinningTableEntity saveTable(DinningTableRequest request);
    DinningTableEntity updateTable(Long id, DinningTableRequest request);
    void deleteTable(Long id);
}
