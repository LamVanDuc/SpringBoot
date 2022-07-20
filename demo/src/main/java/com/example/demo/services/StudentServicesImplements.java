package com.example.demo.services;
import com.example.demo.entities.ResponseObject;
import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImplements implements StudentServices{

    @Autowired StudentRepository repository;

    // get all student
    @Override
    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> findByEmail(String email) {
        List<Student> student = repository.findStudentByEmailContaining(email);
        return !student.isEmpty() ?
                ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok" , "query successfully" ,student))
                :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false" , "Cannot find email ="+email ,""));
    }

    @Override
    public ResponseEntity<ResponseObject> findBySodt(String sdt) {
        List<Student> student = repository.findStudentBySodt(sdt);
        return !student.isEmpty() ?
                ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok" , "query successfully" ,student))
                :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false" , "Cannot find phone number ="+sdt ,""));
    }

    @Override
    public ResponseEntity<ResponseObject> findByDiachi(String diachi) {
        List<Student> student = repository.findStudentByDiachi(diachi);
        return !student.isEmpty() ?
                ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok" , "query successfully" ,student))
                :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false" , "Cannot find student address ="+diachi ,""));
    }

    // find by id
    @Override
    public ResponseEntity<ResponseObject> findById(Long id) {
        Optional<Student> student = repository.findById(id);

        return !student.isEmpty()? ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok" , "query student successfully",student)):
                ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("false" , "cannot student by id = "+id,""));
    }
    // find by name
    @Override
    public ResponseEntity<ResponseObject> findByName(String name) {
        List<Student> student = repository.findStudentByHoten(name);
        return !student.isEmpty() ?
                ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok" , "query successfully" ,student))
                :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false" , "Cannot find student name ="+name ,""));
    }

    // create student
    @Override
    public ResponseEntity<ResponseObject> insertStudent(Student student) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok" , "insert student successfully" , repository.save(student)));
    }


    // update student
    @Override
    public ResponseEntity<ResponseObject> updateStudent(Long id, Student newStudent) {
        Student find = repository.findById(id).map(student ->{
            student.setHoten(newStudent.getHoten());
            student.setDiachi(newStudent.getDiachi());
            student.setSodt(newStudent.getSodt());
            student.setEmail(newStudent.getEmail());
            return repository.save(student);
        }).orElseGet(()->{
            newStudent.setId(id);
           return repository.save(newStudent);
        });
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","Update successfully" , find));
    }

    // delete student
    @Override
    public ResponseEntity<ResponseObject> deleteStudent(Long id) {
        boolean exist = repository.existsById(id);
        if(exist){
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok","delete successfully" , exist));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("false" , "id = "+id +" does not exist",""));
    }
}
