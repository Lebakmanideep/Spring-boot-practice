package com.lov2code.cruddemo.dao;

import com.lov2code.cruddemo.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    // define teh feilds for entity manger

    private EntityManager entityManager;

    // setup constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManger){
        entityManager = theEntityManger;
    }


    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee ", Employee.class);


        //  exxcecute the query

        List<Employee> employees = theQuery.getResultList();

        // return the results

        return employees;


    }

    @Override
    public Employee finById(int theId) {

        // get the employee
        Employee theEmployee = entityManager.find(Employee.class,theId);

        // return the employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save the employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        // return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
        // find employee id
        Employee theEmployee = entityManager.find(Employee.class,theId);

        // remove the employee
        entityManager.remove(theEmployee);

    }
}
