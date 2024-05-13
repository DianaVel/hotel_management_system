package dvel.hotel_management.dto;

import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class EmployeeDTO {
    private int id;

    private String name;

    private String surname;

    @Enumerated
    private String position;
}
