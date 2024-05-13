package dvel.hotel_management.service;

import dvel.hotel_management.db.EmployeeRepo;
import dvel.hotel_management.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee add(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee find(int employeeId) {
        return employeeRepo.findById(employeeId).orElse(null); // დასამატებელი მაქვს შემოწმება თუ იპოვა
    }

    //შემოწმება დასამატებელი
    public Employee delete(int employeeId) {
        Employee employee = find(employeeId);
        employeeRepo.delete(employee);
        return employee;
    }

    public Set<Employee> retrieveAll() {
        return StreamSupport.stream(employeeRepo.findAll().spliterator(), false).collect(Collectors.toSet());
    }
}
