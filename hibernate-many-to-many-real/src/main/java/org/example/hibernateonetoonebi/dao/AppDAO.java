package org.example.hibernateonetoonebi.dao;

import org.example.hibernateonetoonebi.entity.Course;
import org.example.hibernateonetoonebi.entity.Instructor;
import org.example.hibernateonetoonebi.entity.InstructorDetail;
import org.example.hibernateonetoonebi.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findById(Integer id);

    void delete(Integer id);

    InstructorDetail findInsById(Integer id);

    void deleteIns(Integer id);

    List<Course> findCourseByInst(Integer id);

    Instructor joinFetch(Integer id);

    void updateIns(Instructor instructor);

    void updateCourse(Course course);

    Course findCourseById(Integer id);

    void deleteCourse(Integer id);

    void saveCourse(Course course);

    Course findReviewsWithCourse(Integer id);

    Course findByCourseStudentId(Integer id);

    Student findStudentCourses(Integer id);

    void update(Student student);

    void deleteStudent(Integer id);
}
