package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public void addNewStudent(Student student) {
    // print data
    // System.out.println(student);

    // Business logic
    Optional<Student> studentOptional = studentRepository
        .findStudentByEmail(student.getEmail());
    if (studentOptional.isPresent()) {
      // later...
      throw new IllegalStateException("email taken");
    }
    // validation later...
    // ....

    studentRepository.save(student);
  }
}
