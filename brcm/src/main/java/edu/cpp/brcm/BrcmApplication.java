package edu.cpp.brcm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BrcmApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BrcmApplication.class, args);
//		StudentRepository sr = new StudentRepositoryImpl();
//        CustomerRepository cr = new CustomerRepositoryImpl();
//        ProfessorRepository pr = new ProfessorRepositoryImpl();
//        CustomerManagementServiceImpl s = new CustomerManagementServiceImpl(sr, pr, cr);
//        s.saveStudent(new StudentDto(123, LocalDate.now(), "maj", "min", LocalDate.MAX, "fname", "lname", LocalDate.MIN, "12345567"));
//        System.out.println( "Hello World!" );


	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
		return app.sources(BrcmApplication.class);
	}
	@Configuration
	public class WebConfig implements WebMvcConfigurer {
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/**")
					.addResourceLocations("classpath:/static/","classpath:/image/")
					.setCachePeriod(0);
		}
	}


}
