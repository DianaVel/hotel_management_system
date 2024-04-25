package dvel.hotel_management.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
public class Room {
    @Id
    int roomNumber;

    @Column(name = "ROOM_TYPE")
    @Enumerated
    private RoomType roomType;

    @Column (name = "ROOM_STATUS")
    @Enumerated
    private RoomStatus roomStatus;

    @OneToMany(mappedBy = "room")
    private Set<Bookings> bookings;
}
