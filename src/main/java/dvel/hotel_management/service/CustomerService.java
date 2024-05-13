package dvel.hotel_management.service;

import dvel.hotel_management.db.CustomerRepo;
import dvel.hotel_management.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer add(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer find(int id) {
        return customerRepo.findById(id).orElse(null);
    }

    public Customer delete(int id) {
        Customer customer = find(id);
        customerRepo.delete(customer);
        return customer;
    }

    public Set<Customer> retrieveAll() {
        return StreamSupport.stream(customerRepo.findAll().spliterator(), false).collect(Collectors.toSet());
    }
}
