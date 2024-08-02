package com.banvien.Restaurantmanager.repository.DTO;

import com.banvien.Restaurantmanager.domain.entity.EmployeesEntity;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DTOEmployeeRepository extends JpaRepository<EmployeesEntity, Long> {
    @Query(value = "SELECT e.employee_id, e.name, e.position, es.day, s.start_time, s.end_time " +
            "FROM employees e " +
            "LEFT JOIN employee_shift es ON e.employee_id = es.employee_id " +
            "LEFT JOIN shifts s ON es.shift_id = s.shift_id",
            nativeQuery = true)
    public List<Tuple> getAllEmployeeShift();
}
