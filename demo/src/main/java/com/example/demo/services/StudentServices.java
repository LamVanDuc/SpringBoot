package com.example.demo.services;

import com.example.demo.dto.dtoStudent;
import com.example.demo.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServices{

List<dtoStudent> findDtoStudent();


Optional<Student> searchStudentById(Long id);

Student insertStudent(Student newStudent);

boolean removeStudentByid(Long id);

List<Student> searchByName(String name);


 Student updateStudent(Long id,Student newStudent);

 List<Student> getAllStudent();
}
