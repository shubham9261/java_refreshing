package com.learnSpringBoot.demo;

import com.learnSpringBoot.demo.dao.StudentDAO;
import com.learnSpringBoot.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

//@SpringBootApplication(
//		scanBasePackages = {
//				"com.learnSpringBoot.util",
//				"com.learnSpringBoot.demo"
//		}
//)
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
//	After the spring beans have been loadded in application context
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO, String[] args){
		createStudent(studentDAO);
//		deleteStudent(studentDAO);
		return runner -> {
			System.out.println("hello");
		};

	}
	void createStudent(StudentDAO studentDAO){
		Student st=new Student("harish","changdra","sh@gmail.com");
		System.out.println("Saving student"+st.toString());
		studentDAO.save(st);
		System.out.println("Saved student"+st.getId());

		Student fx=studentDAO.findById(st.getId());
		System.out.println("********************");
		System.out.println(fx);

		List<Student>sts=studentDAO.findAll();
		for( Student stu:sts){
			System.out.println(stu);
		}

		sts=studentDAO.findByLastName("changdra");
		for( Student stu:sts){
			System.out.println(stu);
		}
	}

	void updateStudent(StudentDAO studentDAO){
		int id=1;
		Student st=studentDAO.findById(id);
//		Student fx=studentDAO.findById(st.getId());
		st.setEmail("UpdatedEmail@gmail.com");
		studentDAO.update(st);
		st=studentDAO.findById(id);
		System.out.println(st);
	}

	void deleteStudent(StudentDAO studentDAO){
		int id=4;
		studentDAO.delete(id);

		System.out.print("No of rows deleted:::");
		System.out.println(studentDAO.deleteAll());
	}
}
