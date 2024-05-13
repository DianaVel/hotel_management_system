package dvel.hotel_management.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class BookingDTO {
    private int id;

    private int roomNumber;

    private int customerId;

    private Date bookingStartDate;

    private Date bookingEndDate;
}
