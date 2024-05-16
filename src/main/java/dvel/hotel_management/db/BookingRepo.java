package dvel.hotel_management.db;

import dvel.hotel_management.domain.Booking;
import dvel.hotel_management.domain.Customer;
import dvel.hotel_management.domain.Room;
import dvel.hotel_management.domain.RoomType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Set;
import java.util.stream.Stream;

@Repository
public interface BookingRepo extends CrudRepository <Booking, Integer> {
    Set<Booking> findBookingByRoom (Room room);
    Set<Booking> findBookingByCustomer(Customer customer);
    Set<Booking> findBookingByRoomAndBookingStartDateIsBetweenOrBookingEndDateIsBetween (Room room, Date startDate, Date endDate );
}
