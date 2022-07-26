package com.example.demo.controller;
import com.example.demo.dto.ListStudent;
import com.example.demo.entities.ResponseObject;
import com.example.demo.entities.Student;
import com.example.demo.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired private StudentServices student;

    @GetMapping("")
    ListStudent getAllStudent(){
        ListStudent list = new ListStudent();
        list.setData(student.findDtoStudent());
        return list;
    }

    @GetMapping("/get")
    ResponseEntity<ResponseObject> searchStudentBtId(@RequestParam(value = "id")Long id){
        Optional<Student> std = student.searchStudentById(id);
        if (!std.isEmpty() || !std.isPresent()){
          return   ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","query successfully",std));
        }
        return   ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false","Cannot find student by id = "+id,std));
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertStudent(@RequestBody Student newStudent){
       return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok" , "insert successfully ",student.insertStudent(newStudent)));
    }

    @PostMapping("/delete")
    ResponseEntity<ResponseObject> deleteById(@RequestParam(value = "id")Long id){
        boolean delete = student.removeStudentByid(id);
        if (delete){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok" , "delete successfully ", delete));

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false" , "does not exist Student by id ="+id, ""));
        }
    }







}
