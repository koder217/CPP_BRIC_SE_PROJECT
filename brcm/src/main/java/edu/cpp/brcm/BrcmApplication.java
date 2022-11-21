package edu.cpp.brcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BrcmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrcmApplication.class, args);
//		StudentRepository sr = new StudentRepositoryImpl();
//        CustomerRepository cr = new CustomerRepositoryImpl();
//        ProfessorRepository pr = new ProfessorRepositoryImpl();
//        CustomerManagementServiceImpl s = new CustomerManagementServiceImpl(sr, pr, cr);
//        s.saveStudent(new StudentDto(123, LocalDate.now(), "maj", "min", LocalDate.MAX, "fname", "lname", LocalDate.MIN, "12345567"));
//        System.out.println( "Hello World!" );
	}

}
