package com.banvien.Restaurantmanager.service;

import com.banvien.Restaurantmanager.domain.entity.BookingEntity;
import com.banvien.Restaurantmanager.domain.request.BookingRequest;

import java.util.List;

public interface BookingService {
    List<BookingEntity> getAllBookings();
    BookingEntity getBooking(Long id);
    BookingEntity saveBooking(BookingRequest request);
    BookingEntity updateBooking(Long id, BookingRequest request);
    void deleteBooking(Long id);
}
