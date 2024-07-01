package com.banvien.Restaurantmanager.Service;

import com.banvien.Restaurantmanager.domain.entity.ShiftsEntity;
import com.banvien.Restaurantmanager.domain.request.ShiftsRequest;

import java.util.List;

public interface ShiftsService {
    List<ShiftsEntity> getAllShift();
    ShiftsEntity getShift(Long id);
    ShiftsEntity saveShift(ShiftsRequest request);
    void deleteShift(Long id);
}
