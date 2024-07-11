package com.banvien.Restaurantmanager.service.Implement;

import com.banvien.Restaurantmanager.repository.DinningTableRepository;
import com.banvien.Restaurantmanager.service.DinningTableService;
import com.banvien.Restaurantmanager.domain.entity.DinningTableEntity;
import com.banvien.Restaurantmanager.domain.request.DinningTableRequest;
import com.banvien.Restaurantmanager.domain.response.DinningTableResponse;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DinningTableServiceImpl implements DinningTableService {

    @Autowired
    DinningTableRepository tablesRepository;

    public List<DinningTableResponse> getAllTableBookings() {
        List<Tuple> results = tablesRepository.getAllTableBooking();
        return results.stream().map(tuple -> new DinningTableResponse(
                tuple.get("seats", Integer.class),
                tuple.get("table_number", Integer.class),
                tuple.get("dinningtable_id", Long.class),
                tuple.get("status", String.class)
        )).collect(Collectors.toList());
    }

    @Override
    public List<DinningTableEntity> getAllTables() {
        return tablesRepository.findAll();
    }

    @Override
    public DinningTableEntity getTable(Long id) {
        return tablesRepository.findById(id).orElse(null);
    }

    @Override
    public DinningTableEntity saveTable(DinningTableRequest request) {
        DinningTableEntity tables = new DinningTableEntity();
        tables.setTableNumber(request.getTableNumber());
        tables.setSeats(request.getSeats());
        return tablesRepository.save(tables);
    }

    @Override
    public DinningTableEntity updateTable(Long id, DinningTableRequest request) {
        DinningTableEntity existingTable = tablesRepository.findById(id).orElse(null);
        existingTable.setTableNumber(request.getTableNumber());
        existingTable.setSeats(request.getSeats());
        return tablesRepository.save(existingTable);
    }

    @Override
    public void deleteTable(Long id) {
        tablesRepository.deleteById(id);
    }
}
