package com.banvien.Restaurantmanager.controller;

import com.banvien.Restaurantmanager.service.BookingService;
import com.banvien.Restaurantmanager.domain.entity.BookingEntity;
import com.banvien.Restaurantmanager.domain.request.BookingRequest;
import com.banvien.Restaurantmanager.domain.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService reservationService;

    @GetMapping
    public List<BookingEntity> getAllReservation(){
        return reservationService.getAllBookings();
    }

    @GetMapping("/{id}")
    public GenericResponse<String> getReservation(@PathVariable Long id){
        reservationService.getBooking(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Get reservation success")
                .build();
    }

    @PostMapping
    public GenericResponse<String> createReservation(@RequestBody BookingRequest request){
        reservationService.saveBooking(request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Create reservation")
                .build();
    }

    @PutMapping
    public GenericResponse<String> updateReservation(@RequestParam Long id, @RequestBody BookingRequest request){
      reservationService.updateBooking(id,request);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Update reservation success")
                .build();
    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteReservation(@PathVariable Long id){
        reservationService.deleteBooking(id);
        return GenericResponse.<String>builder()
                .success(Boolean.TRUE)
                .message("Delete reservation success")
                .build();
    }
}
