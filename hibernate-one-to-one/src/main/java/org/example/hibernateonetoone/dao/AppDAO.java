package org.example.hibernateonetoone.dao;

import org.example.hibernateonetoone.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(Integer id);

    void delete(Integer id);


}
