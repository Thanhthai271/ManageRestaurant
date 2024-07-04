package com.banvien.Restaurantmanager.Controller;

import com.banvien.Restaurantmanager.Service.ReservationService;
import com.banvien.Restaurantmanager.domain.entity.CustomerEntity;
import com.banvien.Restaurantmanager.domain.entity.ReservationEntity;
import com.banvien.Restaurantmanager.domain.entity.TablesEntity;
import com.banvien.Restaurantmanager.domain.request.ReservationRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping
    public List<ReservationEntity> getAllReservation(){
        return reservationService.getAllReservation();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getReservation(@PathVariable Long id){
        reservationService.getReservation(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get reservation success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createReservation(@RequestBody ReservationRequest request){
        reservationService.saveReservation(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Create reservation")
                .build();
    }

    @PutMapping
    public GenericResponse<String> updateReservation(@RequestParam Long id, @RequestBody ReservationRequest request){
      reservationService.updateReservation(id,request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Update reservation success")
                .build();
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete reservation success")
                .build();
    }
}
