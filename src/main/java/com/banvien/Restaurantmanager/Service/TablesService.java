package com.banvien.Restaurantmanager.Service;

import com.banvien.Restaurantmanager.domain.entity.TablesEntity;
import com.banvien.Restaurantmanager.domain.request.TablesRequest;

import java.util.List;

public interface TablesService {
    List<TablesEntity> getAllTables();
    TablesEntity getTable(Long id);
    TablesEntity saveTable(TablesRequest request);
    void deleteTable(Long id);
}
