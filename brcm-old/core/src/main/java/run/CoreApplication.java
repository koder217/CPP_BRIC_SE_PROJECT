package run;

import dtos.StudentDto;
import impl.CustomerManagementServiceImpl;
import impl.CustomerRepositoryImpl;
import impl.ProfessorRepositoryImpl;
import impl.StudentRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repositories.CustomerRepository;
import repositories.ProfessorRepository;
import repositories.StudentRepository;

import java.time.LocalDate;

@SpringBootApplication
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
//        StudentRepository sr = new StudentRepositoryImpl();
//        CustomerRepository cr = new CustomerRepositoryImpl();
//        ProfessorRepository pr = new ProfessorRepositoryImpl();
//        CustomerManagementServiceImpl s = new CustomerManagementServiceImpl(sr, pr, cr);
//        s.saveStudent(new StudentDto(123, LocalDate.now(), "maj", "min", LocalDate.MAX, "fname", "lname", LocalDate.MIN, "12345567"));
//        System.out.println( "Hello World!" );
    }

}
