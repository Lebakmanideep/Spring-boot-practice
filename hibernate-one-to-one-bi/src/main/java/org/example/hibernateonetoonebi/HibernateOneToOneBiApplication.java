package org.example.hibernateonetoonebi;

import org.example.hibernateonetoonebi.dao.AppDAO;
import org.example.hibernateonetoonebi.entity.Instructor;
import org.example.hibernateonetoonebi.entity.InstructorDetail;
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
    public CommandLineRunner commandLineRunner(AppDAO appDAO){

        return (runner ->
//				createInstructor(appDAO)
//				findById(appDAO)
//              deleteById(appDAO)
//                findInsById(appDAO)
                deleteInsById(appDAO)
        );
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
        appDAO.delete(2);
    }

    private void findById(AppDAO appDAO) {
        System.out.println(appDAO.findById(3));
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor("Mike","Gandhi","mike@email.com");

        InstructorDetail instructorDetail = new InstructorDetail("sample.youtube.url","Fasting");

        instructor.setInstructorDetail(instructorDetail);

        System.out.println("Saving the instructor: "+instructor);

        //will save both the objects because of cascade type all

        appDAO.save(instructor);
    }

}
