package dvel.hotel_management.db;

import dvel.hotel_management.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository <Customer, Integer> {

}
