package com.banvien.Restaurantmanager.controller;


import com.banvien.Restaurantmanager.service.Implement.DinningTableServiceImpl;
import com.banvien.Restaurantmanager.domain.request.DinningTableRequest;
import com.banvien.Restaurantmanager.domain.response.DinningTableResponse;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/dinningTable")
public class DinningTableController {

    @Autowired
    DinningTableServiceImpl tablesService;

    @GetMapping
    public List<DinningTableResponse> dinningTableResponseList(){

        return tablesService.getAllTableBookings();
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
    public GenericResponse<String> createTable(@RequestBody DinningTableRequest request){
        tablesService.saveTable(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Create table succes")
                .build();
    }

    @PutMapping("/{id}")
    public GenericResponse<String> updateTable(@PathVariable Long id, @RequestBody DinningTableRequest request){
        tablesService.updateTable(id,request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Update table success")
                .build();
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteTable(@PathVariable Long id){
        tablesService.deleteTable(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete table success")
                .build();
    }
}
