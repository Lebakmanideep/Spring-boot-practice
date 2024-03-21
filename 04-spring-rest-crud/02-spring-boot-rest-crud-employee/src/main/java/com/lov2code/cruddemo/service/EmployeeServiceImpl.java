package com.lov2code.cruddemo.service;

import com.lov2code.cruddemo.dao.EmployeeDAO;
import com.lov2code.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
class EmployeeServiceImpl implements EmployeeService{



    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl (EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee finById(int theId) {
        return employeeDAO.finById(theId);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }
    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
