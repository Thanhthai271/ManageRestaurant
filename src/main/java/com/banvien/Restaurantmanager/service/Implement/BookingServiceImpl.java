package com.banvien.Restaurantmanager.service.Implement;

import com.banvien.Restaurantmanager.repository.CustomerRespository;
import com.banvien.Restaurantmanager.repository.BookingRepository;
import com.banvien.Restaurantmanager.repository.DinningTableRepository;
import com.banvien.Restaurantmanager.service.BookingService;
import com.banvien.Restaurantmanager.domain.entity.CustomerEntity;
import com.banvien.Restaurantmanager.domain.entity.BookingEntity;
import com.banvien.Restaurantmanager.domain.entity.DinningTableEntity;
import com.banvien.Restaurantmanager.domain.request.BookingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final DinningTableRepository tablesRepository;
    private final CustomerRespository customerRespository;

    @Override
    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingEntity getBooking(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }

    @Override
    public BookingEntity saveBooking(BookingRequest request) {
        BookingEntity booking = new BookingEntity();
        booking.setBookingDateTime(request.getBookingDateTime() );
        booking.setNumberOfGuest(request.getNumberOfGuest());

        DinningTableEntity tablesIdEntity = request.getDinningTableId() != null ? tablesRepository
                .findById(request.getDinningTableId())
                .orElseThrow(() -> new RuntimeException("Table not found")) : null ;

        CustomerEntity customerIdEntity = request.getCustomerId() != null ? customerRespository
                .findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found")) : null;

        booking.setStatus(request.getStatus());
        booking.setCustomerId(customerIdEntity);
        booking.setDinningTableId(tablesIdEntity);

        return bookingRepository.save(booking);
    }

    @Override
    public BookingEntity updateBooking(Long id, BookingRequest request) {
        BookingEntity existingBooking = bookingRepository.findById(id).orElse(null);
        existingBooking.setBookingDateTime(request.getBookingDateTime());
        existingBooking.setNumberOfGuest(request.getNumberOfGuest());

        DinningTableEntity tablesIdEntity = request.getDinningTableId() != null ? tablesRepository
                .findById(request.getDinningTableId())
                .orElseThrow(() -> new RuntimeException("Table not found")) : null;

        CustomerEntity customerIdEntity = request.getCustomerId() != null ? customerRespository
                .findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found")) : null;

        existingBooking.setStatus(request.getStatus());
        existingBooking.setDinningTableId(tablesIdEntity);
        existingBooking.setCustomerId(customerIdEntity);

        return bookingRepository.save(existingBooking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
