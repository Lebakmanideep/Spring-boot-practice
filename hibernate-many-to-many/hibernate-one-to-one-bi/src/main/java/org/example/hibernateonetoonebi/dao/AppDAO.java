package org.example.hibernateonetoonebi.dao;

import org.example.hibernateonetoonebi.entity.Instructor;
import org.example.hibernateonetoonebi.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(Integer id);

    void delete(Integer id);

    InstructorDetail findInsById(Integer id);

    void deleteIns(Integer id);
}
