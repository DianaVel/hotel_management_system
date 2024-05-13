package dvel.hotel_management.db;

import dvel.hotel_management.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository <Employee, Integer> {
}
