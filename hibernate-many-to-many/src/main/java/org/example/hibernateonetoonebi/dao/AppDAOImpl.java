package org.example.hibernateonetoonebi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.hibernateonetoonebi.entity.Course;
import org.example.hibernateonetoonebi.entity.Instructor;
import org.example.hibernateonetoonebi.entity.InstructorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Instructor instructor = entityManager.find(Instructor.class,id);

        List<Course> courses = instructor.getCourses();

        for(Course temp: courses){
            temp.setInstructor(null);
        }

        entityManager.remove(instructor);
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

    @Override
    public List<Course> findCourseByInst(Integer id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id =:data",Course.class);
        query.setParameter("data",id);

        return query.getResultList();
    }

    @Override
    public Instructor joinFetch(Integer id) {

        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i "+
                "JOIN FETCH i.courses "+"JOIN FETCH i.instructorDetail " + "where i.id = :data",Instructor.class);
        query.setParameter("data",id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateIns(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(Integer id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void deleteCourse(Integer id) {
        Course course = entityManager.find(Course.class,id);

        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findReviewsWithCourse(Integer id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                +"JOIN FETCH c.reviews "
                +"where c.id=:data", Course.class
        );

        query.setParameter("data",id);
        return query.getSingleResult();
    }


}
