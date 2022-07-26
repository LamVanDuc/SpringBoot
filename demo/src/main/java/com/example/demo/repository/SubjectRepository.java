package com.example.demo.repository;

import com.example.demo.dto.dtoSubjectCountSem;
import com.example.demo.entities.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subjects, Long> {
    @Query("select s from Subjects s where s.name = ?1")
    Optional<Subjects> findByName(String name);

   List<Subjects> searchBySem(int sem);

   @Query("select s from Subjects s order by s.name")
   List<Subjects> findAllSortByNameAsc();

    @Query("select s from Subjects s order by s.name desc")
    List<Subjects> findAllSortByNameDesc();


    @Query("select s from Subjects s order by s.name,s.id asc ")
    List<Subjects> orderByNameAndId();


    @Query("select count(s.id) from Subjects s")
    List<Object> countBySubject();

    @Query("select new com.example.demo.dto.dtoSubjectCountSem(s.sem,count(s.name)) from Subjects s group by s.sem")
    List<dtoSubjectCountSem> countBySem();


}
