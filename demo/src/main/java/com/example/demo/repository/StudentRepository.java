package com.example.demo.repository;

import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    List<Student> findStudentByHoten(String name);

    List<Student> findStudentByDiachi(String diachi);

    List<Student> findStudentBySodt(String sodt);

    List<Student> findStudentByEmail(String email);
}
