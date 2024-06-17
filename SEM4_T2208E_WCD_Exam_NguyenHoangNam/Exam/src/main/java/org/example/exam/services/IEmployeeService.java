package org.example.exam.services;

import org.example.exam.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(String id);
    void save(Employee employee);
    void update(String id,Employee employee);
    void deleteEmployeeById(String id);
}
