package com.rahul.springjdbc;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rahul.springjdbc.model.Student;
import com.rahul.springjdbc.service.StudentService;

@SpringBootApplication
public class SpringjdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringjdbcApplication.class, args);

		Student s=context.getBean(Student.class);
		s.setName("Rahul");
		s.setRollNo(007);
		s.setMarks(99);

		StudentService service=context.getBean(StudentService.class);
		service.addStudent(s);

		List<Student> students= service.getStudents();
		System.out.println(students);
	}

}
