package com.lov2code.cruddemo;

import com.lov2code.cruddemo.dao.StudentDAO;
import com.lov2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.script.ScriptEngine;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsBYLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count:" + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id : " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		///  retrieve student based on te Id: primary key

		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Scoby"

		System.out.println("updating the student");
		myStudent.setFirstName("john");


		// update the student
		studentDAO.update(myStudent);
		// display the updated student

		System.out.println(myStudent);
	}

	private void queryForStudentsBYLastName(StudentDAO studentDAO) {

		// get the list of students
		List<Student> theStudents = studentDAO.findByLastname("Doe");
		// display the students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of the students
			List<Student> theStudents = studentDAO.findAll();

		// display the list of the  students

		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//  create a student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Daffy", "Duck", "Daffy@luv2code.com");

		// save the student
		System.out.println("saving the student");
		studentDAO.save(tempStudent);
		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved the id of the student"+ theId);
		// retrieve student based on the id: primary key

		System.out.println("Retrieving the id of the student" + theId);
		Student myStudent = studentDAO.findById(theId);
		// display student

		System.out.println(myStudent);


	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple student
		System.out.println("Creating 3 a new object");
		Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student("Mary", "public", "mary@luv2code.com");
		Student tempStudent3 = new Student("Lebak", "Mani", "Lebak@luv2code.com");

		// save the students objects
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object

		System.out.println("Creating a new object");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");

		// save the student object
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);
		// display the saved student

		System.out.println("saved student. Generated id: " + tempStudent.getId());
	}
}
