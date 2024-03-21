package com.lov2code.cruddemo.rest;

import com.lov2code.cruddemo.dao.EmployeeDAO;
import com.lov2code.cruddemo.entity.Employee;
import com.lov2code.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

   private EmployeeService employeeService;
    // quick and dirty : inject employee dao

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // expose "/employee and return a list of employee

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // add mapping for post/ employees - add new employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        // also just in case they pass an id in Json.. set id to 0

        // this is to force a save of new item .. instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }
}
