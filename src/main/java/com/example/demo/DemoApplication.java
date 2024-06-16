package com.example.demo;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.student.Student;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping() //serve as a RESTful endpoint
	public List<Student> hello() {
		return List.of(
					new Student(
							1L,
							"Maryam",
							24,
							LocalDate.of(2000, Month.JANUARY, 5),
							"Maryam@gmail.com")
					
				);
		//return "Hello World";
	}

}
