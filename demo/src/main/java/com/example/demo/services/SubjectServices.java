package com.example.demo.services;

import com.example.demo.entities.ResponseObject;
import com.example.demo.entities.Subjects;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectServices {
    List<Subjects> getAll();

    ResponseEntity<ResponseObject> add(Subjects newSubject);
    ResponseEntity<ResponseObject> getById(Long id);
    ResponseEntity<ResponseObject> editById(Long id, Subjects newSubject);
    ResponseEntity<ResponseObject> deleteById(Long id);
    ResponseEntity<ResponseObject> searchBySem(int sem);
    ResponseEntity<ResponseObject> sortAscByName();
    ResponseEntity<ResponseObject> sortAscByNameAndId();
    ResponseEntity<ResponseObject> sortDescByName();
    ResponseEntity<ResponseObject> countBySubject();
    ResponseEntity<ResponseObject> countSemSubject();
}
