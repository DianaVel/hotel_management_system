package dvel.hotel_management.db;

import dvel.hotel_management.domain.Room;
import dvel.hotel_management.domain.RoomType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Set;

@Repository
public interface RoomRepo extends CrudRepository<Room, Integer> {

    @Query("from Room join Booking where Room .roomType in :roomTypes and :startData not between Booking .bookingStartDate and Booking .bookingEndDate and" +
            ":endDate not between Booking .bookingStartDate and Booking .bookingEndDate")
    Set<Room> findAvailableRooms(@Param("startDate") Date bookingStartDate, @Param("endDate") Date bookingEndDate, @Param("roomTypes") Set<RoomType> roomTypes);

}
