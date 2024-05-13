package dvel.hotel_management.db;

import dvel.hotel_management.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends CrudRepository <Room, Integer> {
}
