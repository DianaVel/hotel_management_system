package dvel.hotel_management.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Employee {
    @Id
    private int id;

    @Column (name = "NAME")
    private String name;

    @Column (name = "SURNAME")
    private String surname;

    @Column (name = "POSITION")
    private String position;

}
