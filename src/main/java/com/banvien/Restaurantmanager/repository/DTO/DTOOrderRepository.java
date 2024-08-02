package com.banvien.Restaurantmanager.repository.DTO;

import com.banvien.Restaurantmanager.domain.entity.OrdersEntity;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DTOOrderRepository extends JpaRepository<OrdersEntity, Long> {
    @Query(value = "SELECT f.name AS foodName, f.price, od.quantity, e.name AS employeeName, c.name AS customerName, " +
            "t.table_number, o.payment_status " +
            "FROM orders o " +
            "LEFT JOIN order_details od ON o.order_id = od.order_id " +
            "LEFT JOIN food f ON od.food_id = f.food_id " +
            "LEFT JOIN employees e ON od.employee_id = e.employee_id " +
            "LEFT JOIN booking b ON o.booking_id = b.booking_id " +
            "LEFT JOIN tables t ON b.dinning_table_id = t.table_id " +
            "LEFT JOIN customer c ON b.customer_id = c.customer_id",
            nativeQuery = true)

    public List<Tuple> GetAllOrder();
}
