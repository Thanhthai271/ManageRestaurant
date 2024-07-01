package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.ShiftsRepository;
import com.banvien.Restaurantmanager.Service.ShiftsService;
import com.banvien.Restaurantmanager.domain.entity.ShiftsEntity;
import com.banvien.Restaurantmanager.domain.request.ShiftsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftsServiceImpl implements ShiftsService {

    @Autowired
    ShiftsRepository shiftsRepository;

    @Override
    public List<ShiftsEntity> getAllShift() {
        return shiftsRepository.findAll();
    }

    @Override
    public ShiftsEntity getShift(Long id) {
        return shiftsRepository.findById(id).orElse(null);
    }

    @Override
    public ShiftsEntity saveShift(ShiftsRequest request) {
        ShiftsEntity shifts = new ShiftsEntity();
        shifts.setShiftDate(request.getShiftdate());
        shifts.setStartTime(request.getStarTime());
        shifts.setEndTime(request.getEndTime());
        return shiftsRepository.save(shifts);
    }

    @Override
    public void deleteShift(Long id) {
        shiftsRepository.deleteById(id);
    }
}
