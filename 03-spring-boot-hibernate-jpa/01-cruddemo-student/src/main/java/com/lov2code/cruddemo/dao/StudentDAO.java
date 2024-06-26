package com.lov2code.cruddemo.dao;

import com.lov2code.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

        List<Student> findAll();

        List<Student> findByLastname(String theLastName);

        void  update(Student theStudent);

        void delete(Integer id);

        int deleteAll();

}
