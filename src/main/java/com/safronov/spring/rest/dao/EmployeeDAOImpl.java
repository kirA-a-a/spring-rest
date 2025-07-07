package com.safronov.spring.rest.dao;

import com.safronov.spring.rest.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        return entityManager.find(Employee.class, empId);
    }

    @Override
    public void deleteEmployee(int empId) {
        Employee emp = entityManager.find(Employee.class, empId);
        if (emp != null) {
            entityManager.remove(emp);
        }
    }
}
