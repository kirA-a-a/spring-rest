package com.safronov.spring.rest.controller;

import com.safronov.spring.rest.entity.Employee;
import com.safronov.spring.rest.exeption_handling.NoSuchEmployeeExtension;
import com.safronov.spring.rest.secvice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Integer id) {

        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            throw new NoSuchEmployeeExtension("Работника с ID = " + id + " нет в БД");
        }

        employeeService.deleteEmployee(id);

        return ResponseEntity
            .ok()
            .contentType(MediaType.valueOf("text/plain; charset=UTF-8"))
            .body("Сотрудник с id = " + id + " был удалён!");
    }
}
