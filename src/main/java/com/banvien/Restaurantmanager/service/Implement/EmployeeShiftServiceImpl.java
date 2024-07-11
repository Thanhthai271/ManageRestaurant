package com.banvien.Restaurantmanager.service.Implement;

import com.banvien.Restaurantmanager.repository.EmployeeShiftRepository;
import com.banvien.Restaurantmanager.repository.EmployeesRepository;
import com.banvien.Restaurantmanager.repository.ShiftsRepository;
import com.banvien.Restaurantmanager.service.EmployeeShiftService;
import com.banvien.Restaurantmanager.domain.entity.EmployeeShiftEntity;
import com.banvien.Restaurantmanager.domain.entity.EmployeesEntity;
import com.banvien.Restaurantmanager.domain.entity.ShiftsEntity;
import com.banvien.Restaurantmanager.domain.request.EmployeeShiftRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeShiftServiceImpl implements EmployeeShiftService {

    private final EmployeeShiftRepository employeeShiftRepository;
    private final ShiftsRepository shiftsRepository;
    private final EmployeesRepository employeesRepository;

    @Override
    public List<EmployeeShiftEntity> getAllEmployeeShift() {
        return employeeShiftRepository.findAll();
    }

    @Override
    public EmployeeShiftEntity getEmployeeShift(Long id) {
        return employeeShiftRepository.findById(id).orElse(null);
    }

    @Override
    public EmployeeShiftEntity saveEmployeeShift(EmployeeShiftRequest request) {
        EmployeeShiftEntity employeeShiftEntity = new EmployeeShiftEntity();
        employeeShiftEntity.setDay(request.getDay());

        ShiftsEntity shiftId = shiftsRepository
                .findById(request.getShiftId())
                .orElseThrow(() -> new RuntimeException("Shift not found"));

        EmployeesEntity employeeId = employeesRepository
                .findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employeeShiftEntity.setShiftId(shiftId);
        employeeShiftEntity.setEmployeeId(employeeId);
        return employeeShiftRepository.save(employeeShiftEntity);
    }

    @Override
    public EmployeeShiftEntity updateEmployeeShift(Long id, EmployeeShiftRequest request) {
        EmployeeShiftEntity existingEmployeeShift = employeeShiftRepository.findById(id).orElse(null);
        existingEmployeeShift.setDay(request.getDay());

        ShiftsEntity shiftId = shiftsRepository
                .findById(request.getShiftId())
                .orElseThrow(() -> new RuntimeException("Shift not found"));

        EmployeesEntity employeeId = employeesRepository
                .findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmployeeShift.setShiftId(shiftId);
        existingEmployeeShift.setEmployeeId(employeeId);
        return employeeShiftRepository.save(existingEmployeeShift);
    }

    @Override
    public void deleteEmployeeShift(Long id) {
        employeeShiftRepository.deleteById(id);
    }
}
