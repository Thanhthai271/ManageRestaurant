package com.banvien.Restaurantmanager.Service.Implement;

import com.banvien.Restaurantmanager.Repository.TablesRepository;
import com.banvien.Restaurantmanager.Service.TablesService;
import com.banvien.Restaurantmanager.domain.entity.TablesEntity;
import com.banvien.Restaurantmanager.domain.request.TablesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablesServiceImpl implements TablesService {

    @Autowired
    TablesRepository tablesRepository;

    @Override
    public List<TablesEntity> getAllTables() {
        return tablesRepository.findAll();
    }

    @Override
    public TablesEntity getTable(Long id) {
        return tablesRepository.findById(id).orElse(null);
    }

    @Override
    public TablesEntity saveTable(TablesRequest request) {
        TablesEntity tables = new TablesEntity();
        tables.setTableNumber(request.getTableNumber());
        tables.setSeats(request.getSeats());
        return tablesRepository.save(tables);
    }

    @Override
    public TablesEntity updateTable(Long id, TablesRequest request) {
        TablesEntity existingTable = tablesRepository.findById(id).orElse(null);
        existingTable.setTableNumber(request.getTableNumber());
        existingTable.setSeats(request.getSeats());
        return tablesRepository.save(existingTable);
    }

    @Override
    public void deleteTable(Long id) {
        tablesRepository.deleteById(id);
    }
}
