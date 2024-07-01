package com.banvien.Restaurantmanager.Controller;


import com.banvien.Restaurantmanager.Service.Implement.TablesServiceImpl;
import com.banvien.Restaurantmanager.domain.entity.TablesEntity;
import com.banvien.Restaurantmanager.domain.request.CustomerRequest;
import com.banvien.Restaurantmanager.domain.request.TablesRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class TablesController {

    @Autowired
    TablesServiceImpl tablesService;

    @GetMapping
    public List<TablesEntity> getAllTables(){
        return tablesService.getAllTables();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getTable(@PathVariable Long id){
        tablesService.getTable(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get table success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createTable(@RequestBody TablesRequest request){
        tablesService.saveTable(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Create table succes")
                .build();
    }

    @PutMapping
    public GenericResponse<String> updateTable(@RequestParam Long id, @RequestBody TablesRequest request){
        request.setTableId(id);
        tablesService.saveTable(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Update table success")
                .build();
    }

    @DeleteMapping
    public GenericResponse<String> deleteTable(Long id){
        tablesService.deleteTable(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete table success")
                .build();
    }
}
