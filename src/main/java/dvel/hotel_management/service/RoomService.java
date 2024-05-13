package dvel.hotel_management.service;

import dvel.hotel_management.db.RoomRepo;
import dvel.hotel_management.domain.Room;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoomService {
    private final RoomRepo roomRepo;
    public RoomService (RoomRepo roomRepo){
        this.roomRepo = roomRepo;
    }

    public Room add (Room room){
        return roomRepo.save(room);
    }

    public Room find (int roomNumber){
        return roomRepo.findById(roomNumber).orElse(null);
    }

    public Room delete (int roomNumber){
        Room room = find(roomNumber);
        roomRepo.delete(room);
        return room;
    }

    public Set<Room> retrieveAll(){
       return StreamSupport.stream(roomRepo.findAll().spliterator(),false).collect(Collectors.toSet());
    }
}
