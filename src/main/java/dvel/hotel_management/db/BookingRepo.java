package dvel.hotel_management.db;

import dvel.hotel_management.domain.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends CrudRepository <Booking, Integer> {
}
