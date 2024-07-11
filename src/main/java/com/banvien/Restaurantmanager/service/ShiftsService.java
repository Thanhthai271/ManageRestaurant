package com.banvien.Restaurantmanager.service;

import com.banvien.Restaurantmanager.domain.entity.ShiftsEntity;
import com.banvien.Restaurantmanager.domain.request.ShiftsRequest;

import java.util.List;

public interface ShiftsService {
    List<ShiftsEntity> getAllShift();
    ShiftsEntity getShift(Long id);
    ShiftsEntity saveShift(ShiftsRequest request);
    ShiftsEntity updateShift(Long id, ShiftsRequest request);
    void deleteShift(Long id);
}
