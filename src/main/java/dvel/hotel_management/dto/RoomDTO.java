package dvel.hotel_management.dto;

import dvel.hotel_management.domain.RoomStatus;
import dvel.hotel_management.domain.RoomType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RoomDTO {

    int roomNumber;

    @Enumerated
    private RoomType roomType;

    @Enumerated
    private RoomStatus roomStatus;

}
