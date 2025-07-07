package com.safronov.spring.rest.dao;


import com.safronov.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int empId);

    public void deleteEmployee(int empId);
}
