package com.safronov.spring.rest.controller;

import com.safronov.spring.rest.entity.Employee;
import com.safronov.spring.rest.exeption_handling.NoSuchEmployeeExtension;
import com.safronov.spring.rest.secvice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id) {

        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            throw new NoSuchEmployeeExtension(String.format("Работника с id = '%d' нет в БД", id));
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);
        
    }
}
