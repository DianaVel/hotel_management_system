package dvel.hotel_management.service;

import dvel.hotel_management.db.BookingRepo;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingRepo bookingRepo;
    public BookingService (BookingRepo bookingRepo){
        this.bookingRepo = bookingRepo;
    }

}
