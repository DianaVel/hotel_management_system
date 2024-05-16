package dvel.hotel_management.service;

import dvel.hotel_management.db.BookingRepo;
import dvel.hotel_management.db.PriceRepo;
import dvel.hotel_management.db.RoomRepo;
import dvel.hotel_management.domain.Booking;
import dvel.hotel_management.domain.Customer;
import dvel.hotel_management.domain.Room;
import dvel.hotel_management.domain.RoomType;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookingService {
    private final BookingRepo bookingRepo;
    private final RoomRepo roomRepo;
    private final PriceRepo priceRepo;
    public BookingService (BookingRepo bookingRepo, RoomRepo roomRepo, PriceRepo priceRepo){
        this.bookingRepo = bookingRepo;
        this.roomRepo = roomRepo;
        this.priceRepo = priceRepo;
    }

    public Booking addBooking(Booking booking){
        if(isRoomAvailable(booking)){
            return bookingRepo.save(booking);
        }else {
            throw new RuntimeException("Booking is not available"); // ეს დასახვეწი მაქვს
        }

    }

    public Set <Booking> getAllBookings (){
        return StreamSupport.stream(bookingRepo.findAll().spliterator(),false).collect(Collectors.toSet());
    }

    public Set <Room> getAvailableRooms (Date bookingStartDate, Date bookingEndDate, double roomMinPrice, double roomMaxPrice){
        var roomTypes = priceRepo.findRoomTypesByPriceIsBetween(roomMinPrice,roomMaxPrice);
        return roomRepo.findAvailableRooms(bookingStartDate,bookingEndDate,roomTypes);
    }


    public Set<Booking> findBookingsByRoom(Room room){
       return bookingRepo.findBookingByRoom(room);
    }

    public Set <Booking> findBookingsByCustomer(Customer customer){
        return bookingRepo.findBookingByCustomer(customer);
    }

    private boolean isRoomAvailable (Booking booking){
        var bookings = bookingRepo.findBookingByRoomAndBookingStartDateIsBetweenOrBookingEndDateIsBetween(booking.getRoom(),booking.getBookingStartDate(), booking.getBookingEndDate());
           if(bookings.isEmpty() ){
               return true;
           }else {
               return false;
           }
      }
}
