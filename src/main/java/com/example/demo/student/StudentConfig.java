package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository)
	{
		return args -> {
			Student mariam = new Student(
			"Maryam",
			24,
			LocalDate.of(2000, Month.JANUARY, 5),
			"Maryam@gmail.com"
			);
			
			Student alex = new Student(
			"alex",
			21,
			LocalDate.of(2004, Month.JANUARY, 5),
			"alex@gmail.com"
			);
			repository.saveAll(List.of(mariam,alex));
		};
	}
	
}
