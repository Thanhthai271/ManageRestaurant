package com.banvien.Restaurantmanager.repository;

import com.banvien.Restaurantmanager.domain.entity.DinningTableEntity;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DinningTableRepository extends JpaRepository<DinningTableEntity, Long> {

    @Query(value = "SELECT t.table_id, t.seats, t.table_number, t.dinningtable_id, b.status " +
            "FROM tables t LEFT JOIN booking b ON t.table_id = b.dinning_table_id",
            nativeQuery = true)
    List<Tuple> getAllTableBooking();
}
