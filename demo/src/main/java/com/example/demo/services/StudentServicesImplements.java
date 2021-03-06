package com.example.demo.services;
import com.example.demo.dto.dtoStudent;
import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImplements implements StudentServices{

    @Autowired StudentRepository repository;


    @Override
    public List<Student> getAllStudent(){
        return repository.findAll();
    }

    @Override
    public List<dtoStudent> findDtoStudent() {
        return repository.findAllWithDtoStudent();
    }

    @Override
    public Optional<Student> searchStudentById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Student insertStudent(Student newStudent) {
        return repository.save(newStudent);
    }

    @Override
    public boolean removeStudentByid(Long id) {
        boolean exist = repository.existsById(id);
        if (exist){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> searchByName(String name) {
        return repository.findStudentByName(name);
    }

    @Override
    public Student updateStudent(Long id, Student newStudent) {
        Student student = repository.findById(id).map(std->{
            std.setName(newStudent.getName());
            std.setAddress(newStudent.getAddress());
            std.setEmail(newStudent.getEmail());
            std.setPhoneNumber(newStudent.getPhoneNumber());
            return  repository.save(std);
        }).orElseGet(()->{
            newStudent.setId(id);
            return repository.save(newStudent);
        });
        return student;
    }


}
