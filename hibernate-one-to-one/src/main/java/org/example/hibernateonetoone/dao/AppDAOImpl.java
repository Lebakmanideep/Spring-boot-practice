package org.example.hibernateonetoone.dao;

import jakarta.persistence.EntityManager;
import org.example.hibernateonetoone.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(Integer id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        entityManager.remove(entityManager.find(Instructor.class,id));
    }


}
