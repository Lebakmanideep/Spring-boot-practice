package com.kuv2code.demo.rest;

import com.kuv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    // define @postConstruct ton load the student data

    @PostConstruct
    public void loadData() {
       theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima","patel"));
        theStudents.add(new Student("Lebak","Mani"));
        theStudents.add(new Student("Reddy","JJ"));
    }
    // define the end points for / students  to return the list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    // define end point or "/student/{student id}" -- return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // just index the list

        // check the student id agian in the list size

        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }


        return theStudents.get(studentId);
    }

    //add an exception handler using @Exceptionhandelr


}
