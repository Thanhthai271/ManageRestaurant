package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.EmployeesRepository;
import com.banvien.Restaurantmanager.Repository.ShiftsRepository;
import com.banvien.Restaurantmanager.Service.ShiftsService;
import com.banvien.Restaurantmanager.domain.entity.EmployeesEntity;
import com.banvien.Restaurantmanager.domain.entity.ShiftsEntity;
import com.banvien.Restaurantmanager.domain.request.ShiftsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftsServiceImpl implements ShiftsService {

    private final EmployeesRepository employeesRepository;
    private final ShiftsRepository shiftsRepository;

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
        shifts.setName(request.getName());
        shifts.setStartTime(request.getStartTime());
        shifts.setEndTime(request.getEndTime());

        return shiftsRepository.save(shifts);
    }

    @Override
    public ShiftsEntity updateShift(Long id, ShiftsRequest request) {
        ShiftsEntity existingShift = shiftsRepository.findById(id).orElse(null);
        existingShift.setName(request.getName());
        existingShift.setStartTime(request.getStartTime());
        existingShift.setEndTime(request.getEndTime());

        return shiftsRepository.save(existingShift);
    }

    @Override
    public void deleteShift(Long id) {
        shiftsRepository.deleteById(id);
    }
}
