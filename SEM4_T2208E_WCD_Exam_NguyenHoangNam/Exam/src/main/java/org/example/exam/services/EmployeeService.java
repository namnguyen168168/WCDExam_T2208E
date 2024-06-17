package org.example.exam.services;

import org.example.exam.entities.Employee;
import org.example.exam.repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    private final IEmployeeRepository iEmployeeRepository;
    @Autowired
    public EmployeeService(IEmployeeRepository iEmployeeRepository){
        this.iEmployeeRepository=iEmployeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(String id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public void update(String id, Employee updateEmployee) {
        var existingEmployeeOptional = getEmployeeById(id);
        if(existingEmployeeOptional.isPresent()){
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setEmployeeName(updateEmployee.getEmployeeName());
            existingEmployee.setBirthday(updateEmployee.getBirthday());
            existingEmployee.setAddress(updateEmployee.getAddress());
            existingEmployee.setPosition(updateEmployee.getPosition());
            existingEmployee.setDepartment(updateEmployee.getDepartment());
            iEmployeeRepository.save(existingEmployee);
        }
    }

    @Override
    public void deleteEmployeeById(String id) {
        iEmployeeRepository.deleteById(id);
    }
}
