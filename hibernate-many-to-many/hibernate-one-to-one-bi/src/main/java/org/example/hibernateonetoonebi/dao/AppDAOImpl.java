package org.example.hibernateonetoonebi.dao;

import jakarta.persistence.EntityManager;
import org.example.hibernateonetoonebi.entity.Instructor;
import org.example.hibernateonetoonebi.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO{
    private final EntityManager entityManager;

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

    @Override
    public InstructorDetail findInsById(Integer id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteIns(Integer id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,id);

        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);
    }
}
