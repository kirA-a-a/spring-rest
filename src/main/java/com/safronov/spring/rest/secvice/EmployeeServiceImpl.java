package com.safronov.spring.rest.secvice;

import com.safronov.spring.rest.dao.EmployeeDAOImpl;
import com.safronov.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAOImpl employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int empId) {
        return employeeDAO.getEmployeeById(empId);
    }

    @Override
    @Transactional
    public void deleteEmployee(int empId) {
        employeeDAO.deleteEmployee(empId);
    }
}
