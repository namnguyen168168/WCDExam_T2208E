package org.example.exam.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employeeId", nullable = false)
    @NotEmpty(message = "The Employee Id Field is not empty.")
    public String employeeId;

    @Column(name = "employeeName", nullable = false)
    @NotEmpty(message = "The Employee Name Field is not empty.")
    public String employeeName;

    @Column(name = "birthday", nullable = false)
    @NotEmpty(message = "The Birthday Field is not empty.")
    public Date birthday;

    @Column(name = "address", nullable = false)
    @NotEmpty(message = "The Address Field is not empty.")
    public String address;

    @Column(name = "position", nullable = false)
    @NotEmpty(message = "The Position Field is not empty.")
    public String position;

    @Column(name = "department", nullable = false)
    @NotEmpty(message = "The Department Field is not empty.")
    public String department;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, Date birthday, String address, String position, String department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.position = department;
    }
}
