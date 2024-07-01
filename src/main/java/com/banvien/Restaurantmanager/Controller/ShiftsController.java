package com.banvien.Restaurantmanager.Controller;

import com.banvien.Restaurantmanager.Service.ShiftsService;
import com.banvien.Restaurantmanager.domain.request.ShiftsRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shifts")
public class ShiftsController {

    @Autowired
    ShiftsService shiftsService;

    @GetMapping
    public GenericResponse<String> getAllShift(){
        shiftsService.getAllShift();
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Save shift success")
                .build();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getShift(@PathVariable Long id){
        shiftsService.getShift(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get shift success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createShift(@RequestBody ShiftsRequest request){
        shiftsService.saveShift(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Create shift success")
                .build();
    }

    @PutMapping
    public GenericResponse<String> updateShift(@PathVariable Long id, @RequestBody ShiftsRequest request){
        request.setShiftId(id);
        shiftsService.saveShift(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Update shift succes")
                .build();
    }

    @DeleteMapping
    public GenericResponse<String> deleteShift(@PathVariable Long id){
        shiftsService.deleteShift(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete shift success")
                .build();
    }
}

