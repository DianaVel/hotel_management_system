package dvel.hotel_management.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@Entity
@SequenceGenerator(name = "BOOKING_ID_GENERATOR", sequenceName = "BOOKING_ID_SEQUENCE", allocationSize = 1)
public class Bookings {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOKING_ID_GENERATOR")
    @Id
    private int id;

    @ManyToOne()
    @JoinColumn(name = "ROOM_ID")
    private Room room;

    @ManyToOne()
    @JoinColumn(name = "CUSTOMER_ID)")
    private Customer customer;

    @Column (name = "BOOKING_START_DATE")
    private Date bookingStartDate;

    @Column (name = "BOOKING_END_DATE")
    private Date bookingEndDate;

}
