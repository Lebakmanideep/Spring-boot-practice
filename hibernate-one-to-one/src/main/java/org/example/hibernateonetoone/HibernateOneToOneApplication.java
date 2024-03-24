package org.example.hibernateonetoone;

import org.example.hibernateonetoone.dao.AppDAO;
import org.example.hibernateonetoone.entity.Instructor;
import org.example.hibernateonetoone.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateOneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return (runner ->
//				createInstructor(appDAO)
//				findById(appDAO)
				deleteById(appDAO)
		);
	}

	private void deleteById(AppDAO appDAO) {
		appDAO.delete(3);
	}

	private void findById(AppDAO appDAO) {
		System.out.println(appDAO.findById(3));
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Mohan","Gandhi","mohan@email.com");

		InstructorDetail instructorDetail = new InstructorDetail("sample.youtube.url","Fasting");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving the instructor: "+instructor);

		//will save both the objects because of cascade type all

		appDAO.save(instructor);
	}

}
