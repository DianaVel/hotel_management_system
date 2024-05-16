package dvel.hotel_management.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Price {
    @Id
    private Long id;

    @Column(unique = true)
    private RoomType roomType;

    @Column
    private double price;
}
