package com.example.demo.controller;

import com.example.demo.entities.ResponseObject;
import com.example.demo.entities.Subjects;
import com.example.demo.services.SubjectServicesImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/subject")
public class SubjectController {
    @Autowired SubjectServicesImplements subjectimplement;

    @GetMapping("")
    List<Subjects> getAll(){
        return subjectimplement.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> getById(@PathVariable Long id){
        return subjectimplement.getById(id);
    }

    @PostMapping("/add")
    ResponseEntity<ResponseObject> addSubject(@RequestBody Subjects newSubject){
        return subjectimplement.add(newSubject);
    }


    @PutMapping("/update/{id}")
    ResponseEntity<ResponseObject> updateSubject(@PathVariable Long id , @RequestBody Subjects newSubject){
        return subjectimplement.editById(id , newSubject);
    }


    @DeleteMapping("/delete")
    ResponseEntity<ResponseObject> deleteSubject(@RequestParam(value = "id")Long id){
        return subjectimplement.deleteById(id);
    }

    @GetMapping("/search")
    ResponseEntity<ResponseObject> searchBySem(@RequestParam(value = "sem") int sem){
        return subjectimplement.searchBySem(sem);
    }

    @GetMapping("/sortbyname")
    ResponseEntity<ResponseObject> sortByNameAsc(){
        return subjectimplement.sortAscByName();
    }

    @GetMapping("/sortbynamedesc")
    ResponseEntity<ResponseObject> sortByNameDesc(){
        return subjectimplement.sortDescByName();
    }

    @GetMapping("/sortnameandid")
    ResponseEntity<ResponseObject> sortByNameAndId(){
        return subjectimplement.sortAscByNameAndId();
    }
    @GetMapping("/count/subject")
    ResponseEntity<ResponseObject> countSubject(){
        return subjectimplement.countBySubject();
    }

    @GetMapping("/count/sem")
    ResponseEntity<ResponseObject> countBySem(){
        return subjectimplement.countSemSubject();
    }










}
