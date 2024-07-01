package com.banvien.Restaurantmanager.Repository;

import com.banvien.Restaurantmanager.domain.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<EmployeesEntity, Long> {
}
