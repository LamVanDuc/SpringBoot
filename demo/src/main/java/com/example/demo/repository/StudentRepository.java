package com.example.demo.repository;

import com.example.demo.dto.dtoStudent;
import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {



    @Query("select new com.example.demo.dto.dtoStudent(s.name,s.address,s.phoneNumber,s.email,s.classid) from Student s")
    List<dtoStudent> findAllWithDtoStudent();


//    @Query("SELECT new com.example.demo.dto.dtoStudent(s.id , s.name ,s.address , s.phoneNumber , s.email , s.classid)from Student s")
//    List<dtoStudent> findAllStudents();

    @Query("select s from Student s where s.name = ?1")
    List<Student> findStudentByName(String name);

    List<Student> findStudentByEmail(String diachi);

    List<Student> findStudentByPhoneNumber(String sodt);



    @Query("select s from Student s where s.email like concat('%', ?1, '%')")
    List<Student> findStudentByEmailContaining(String email);
}