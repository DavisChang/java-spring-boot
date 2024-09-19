package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.Student;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// @GetMapping
	// public String hello() {
	// return "Hello World";
	// }

	@GetMapping
	public List<Student> hello() {
		return List.of(new Student(1L, "Davis", "davis@gmail.com", LocalDate.of(2000, 12, 12), 21));
	}

}
