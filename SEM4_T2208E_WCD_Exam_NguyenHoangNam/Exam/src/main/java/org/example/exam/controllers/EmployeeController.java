package org.example.exam.controllers;

import jakarta.validation.Valid;
import org.example.exam.entities.Employee;
import org.example.exam.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("list")
    public String getAllEmployees(Model model){
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "/employee/Index";
    }

    @GetMapping("add")
    public String add(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/employee/Add";
    }

    @PostMapping("add")
    public String add(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "employee/Add";
        }
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("edit")
    public String edit(@RequestParam String id, Model model){
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(id);
        if(employeeOptional.isPresent()){
            var employee = employeeOptional.get();
            model.addAttribute("employee", employee);
        }
        return "/employee/Edit";
    }

    @PostMapping("edit")
    public String edit(@RequestParam String id, Model model, @ModelAttribute("employee") Employee employee){
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(id);
        if(employeeOptional.isPresent()){
            employeeService.update(id, employee);
            model.addAttribute("employee", employee);
            return "redirect:/employees/list";
        }else {
            return "redirect:/employees/list";
        }
    }

    @GetMapping("delete")
    public String delete(String id){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees/list";
    }
}
