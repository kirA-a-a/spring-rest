package com.safronov.spring.rest.dao;

import com.safronov.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.unwrap(Session.class);
        return session.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployeeById(int empId) {
        Session session = sessionFactory.unwrap(Session.class);
        return session.get(Employee.class, empId);
    }

    @Override
    public void deleteEmployee(int empId) {
        Session session = sessionFactory.unwrap(Session.class);
        org.hibernate.query.Query query = session.createQuery("delete from Employee where id =:id");
        query.setParameter("id", empId);
        query.executeUpdate();
    }
}
