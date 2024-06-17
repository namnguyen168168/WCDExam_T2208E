package org.example.exam.repositories;

import org.example.exam.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, String> {
}
