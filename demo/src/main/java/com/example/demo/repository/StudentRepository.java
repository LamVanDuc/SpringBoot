package com.example.demo.repository;

import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    List<Student> findStudentByHoten(String name);

    List<Student> findStudentByDiachi(String diachi);

    List<Student> findStudentBySodt(String sodt);

    @Query("select s from Student s where s.email like concat('%', ?1, '%')")
    List<Student> findStudentByEmailContaining(String email);
}