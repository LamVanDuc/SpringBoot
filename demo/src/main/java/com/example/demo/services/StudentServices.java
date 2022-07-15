package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.entities.ResponseObject;
import com.example.demo.entities.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentServices{

    List<?> getAllStudent();
    ResponseEntity<ResponseObject> findByEmail(String email);

    ResponseEntity<ResponseObject> findBySodt(String sdt);

    ResponseEntity<ResponseObject> findByDiachi(String diachi);

    ResponseEntity<?> findById(Long id);


    ResponseEntity<?> findByName(String name);


    ResponseEntity<?> insertStudent(Student student);

    ResponseEntity<?> updateStudent(Long id , Student newStudent);

    ResponseEntity<?> deleteStudent(Long id);


}
