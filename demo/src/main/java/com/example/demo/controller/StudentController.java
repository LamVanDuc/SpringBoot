package com.example.demo.controller;

import com.example.demo.entities.ResponseObject;
import com.example.demo.entities.Student;
import com.example.demo.services.StudentServicesImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired private StudentServicesImplements student;

    @GetMapping("")
    public List<Student> getAllStudent(){
        return student.getAllStudent();
    }


    @GetMapping("/searchByName")
    public ResponseEntity<ResponseObject> searchByName(@RequestParam(value = "name")String name){
        return student.findByName(name);
    }

    @GetMapping("/searchById")
    public ResponseEntity<ResponseObject> searchById(@RequestParam(value = "id")Long id){
        return student.findById(id);
    }

    @GetMapping("/searchByEmail")
    public ResponseEntity<ResponseObject> searchByEmail(@RequestParam(value = "email")String email){
        return student.findByEmail(email);
    }

    @GetMapping("/searchByPhone")
    public ResponseEntity<ResponseObject> searchByPhone(@RequestParam(value = "phone") String phone){
        return student.findBySodt(phone);
    }

    @GetMapping("/searchByAddress/{address}")
    public ResponseEntity<ResponseObject> searchByAddress(@PathVariable String address){
        return student.findByDiachi(address);
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertStudent(@RequestBody Student newStudent){
        return student.insertStudent(newStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteStudent(@PathVariable Long id){
        return student.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateStudent(@PathVariable Long id , @RequestBody Student newStudent){
        return student.updateStudent(id,newStudent);
    }









}
