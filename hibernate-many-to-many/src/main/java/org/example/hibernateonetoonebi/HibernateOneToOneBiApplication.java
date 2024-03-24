package org.example.hibernateonetoonebi;

import org.example.hibernateonetoonebi.dao.AppDAO;
import org.example.hibernateonetoonebi.entity.Course;
import org.example.hibernateonetoonebi.entity.Instructor;
import org.example.hibernateonetoonebi.entity.InstructorDetail;
import org.example.hibernateonetoonebi.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateOneToOneBiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateOneToOneBiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return (runner ->
                deleteCourseById(appDAO)

        );
    }

    private void fetchReviews(AppDAO appDAO) {
        Course course = appDAO.findReviewsWithCourse(16);
        System.out.println(course);
        System.out.println(course.getReviews());
    }

    private void createReviews(AppDAO appDAO) {
        Course course = new Course("Joke");

        course.addReview(new Review("Bad"));
        course.addReview(new Review("Good"));
        course.addReview(new Review("Snooze fest"));

        appDAO.saveCourse(course);

    }


    private void deleteCourseById(AppDAO appDAO) {
        appDAO.deleteCourse(16);
    }

    private void updateCourse(AppDAO appDAO) {
        int id = 10;

        Course course = appDAO.findCourseById(id);
        System.out.println(course);
        course.setTitle("Cyberpunk");
        appDAO.updateCourse(course);
        Course course1 = appDAO.findCourseById(id);
        System.out.println(course1);
    }

    private void updateIns(AppDAO appDAO) {
        int id =3;

        Instructor instructor = appDAO.findById(id);
        instructor.setEmail("donkey@email.com");
        appDAO.updateIns(instructor);
        Instructor instructor1 = appDAO.findById(id);
        System.out.println(instructor1);

    }


    private void joinFetch(AppDAO appDAO) {
        int id=3;
        Instructor instructor = appDAO.joinFetch(id);

        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void lazyLoadCourses(AppDAO appDAO) {
        int id = 3;
        Instructor instructor = appDAO.findById(id);

        System.out.println(instructor);
        System.out.println(appDAO.findCourseByInst(id));
    }

    private void findInsWithCourses(AppDAO appDAO) {
        int id = 3;
        Instructor instructor = appDAO.findById(id);

        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void createInsWithCourses(AppDAO appDAO) {
        Instructor instructor = new Instructor("Maki", "Zenin", "maki@email.com");

        InstructorDetail instructorDetail = new InstructorDetail("sample.youtube.url", "Mei");

        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving the instructor: " + instructor);

        //will save both the objects because of cascade type all
        Course course = new Course("Close Combat");
        Course course1 = new Course("Body Press");

        instructor.addCourse(course);
        instructor.addCourse(course1);

        //saving instructor will also save courses because of cascade type being persist
        System.out.println(instructor);
        System.out.println(instructor.getCourses());

        appDAO.save(instructor);
    }

    private void deleteInsById(AppDAO appDAO) {

        appDAO.deleteIns(1);

        System.out.println("Delete successful");
    }

    private void findInsById(AppDAO appDAO) {
        System.out.println(appDAO.findInsById(4));
        System.out.println(appDAO.findInsById(4).getInstructor());
    }

    private void deleteById(AppDAO appDAO) {
        appDAO.delete(3);
    }

    private void findById(AppDAO appDAO) {
        System.out.println(appDAO.findById(3));
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor("Mike", "Gandhi", "mike@email.com");

        InstructorDetail instructorDetail = new InstructorDetail("sample.youtube.url", "Fasting");

        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving the instructor: " + instructor);

        //will save both the objects because of cascade type all

        appDAO.save(instructor);
    }

}
