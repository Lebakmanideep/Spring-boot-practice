package com.lov2code.cruddemo.dao;

import com.lov2code.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();


    Employee finById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
