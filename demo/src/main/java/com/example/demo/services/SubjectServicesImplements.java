package com.example.demo.services;

import com.example.demo.dto.dtoSubjectCountSem;
import com.example.demo.entities.ResponseObject;
import com.example.demo.entities.Subjects;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServicesImplements implements SubjectServices{
    @Autowired SubjectRepository subject;

    @Override
    public List<Subjects> getAll() {
        return subject.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> add(Subjects newSubject) {
        Optional<?> findName = subject.findByName(newSubject.getName());
        if (!findName.isEmpty()){
            return  ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","add successfully",subject.save(newSubject)));
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false","subject : "+newSubject.getName()+" already exist",""));
        }
    }

    @Override
    public ResponseEntity<ResponseObject> getById(Long id) {
        Optional<?> findid = subject.findById(id);
        if (findid.isEmpty()){
            return  ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","query successfully",findid));
        }else {
            return  ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("false","Cannot find subject by id= "+id,""));
        }
    }

    @Override
    public ResponseEntity<ResponseObject> editById(Long id , Subjects newSubject) {
        Subjects edit = subject.findById(id).map(sub -> {
            sub.setName(newSubject.getName());
            sub.setDescription(newSubject.getDescription());
            sub.setSem(newSubject.getSem());
            sub.setDuration(newSubject.getDuration());
            return subject.save(sub);
        }).orElseGet(()->{
            newSubject.setId(id);
            return subject.save(newSubject);
                });
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok" ,"Update successfully", edit));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteById(Long id) {
        boolean exist = subject.existsById(id);
        if (exist){
            subject.deleteById(id);
            return  ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","delete successfully",exist));
        }else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false","Cannot find subject by id ="+id,""));
        }
    }


    @Override
    public ResponseEntity<ResponseObject> searchBySem(int sem) {
        List<Subjects> query = subject.searchBySem(sem);
        if (!query.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok","query successfully",query));
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("false","Cannot find sem = "+sem,""));
        }
    }

    @Override
    public ResponseEntity<ResponseObject> sortAscByName() {
        List<Subjects> subjects = subject.findAllSortByNameAsc();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok" ,"sort by name asc" , subjects));
    }

    @Override
    public ResponseEntity<ResponseObject> sortAscByNameAndId() {
        List<Subjects> subjects = subject.orderByNameAndId();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok" ,"sort by name and id" , subjects));
    }

    @Override
    public ResponseEntity<ResponseObject> sortDescByName() {
        List<Subjects> subjects = subject.findAllSortByNameDesc();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok" ,"sort by name desc" , subjects));
    }

    @Override
    public ResponseEntity<ResponseObject> countBySubject() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok" ,"count by subject" , subject.countBySubject()));
    }

    @Override
    public ResponseEntity<ResponseObject> countSemSubject() {
        List<dtoSubjectCountSem> count =  subject.countBySem();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok" ,"count by sem" , count));
    }
}
