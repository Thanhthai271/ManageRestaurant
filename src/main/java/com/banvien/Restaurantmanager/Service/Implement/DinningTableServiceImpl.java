package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.DinningTableRepository;
import com.banvien.Restaurantmanager.Service.DinningTableService;
import com.banvien.Restaurantmanager.domain.entity.DinningTableEntity;
import com.banvien.Restaurantmanager.domain.request.DinningTableRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DinningTableServiceImpl implements DinningTableService {

    @Autowired
    DinningTableRepository tablesRepository;

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
