package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
      Student davis = new Student(
          "Davis",
          "davis@gmail.com",
          LocalDate.of(2000, 2, 5));

      Student alex = new Student(
          "Alex",
          "Alex@gmail.com",
          LocalDate.of(2002, 3, 5));

      repository.saveAll(List.of(davis, alex));
    };
  };
}
