package dvel.hotel_management.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
public class Customer {
    @Id
    private int ID;

    @Column(name = "NAME")
    private String name;

    @Column (name = "SURNAME")
    private String surname;

    @OneToMany(mappedBy = "customer")
    private Set<Bookings> bookings;
}
