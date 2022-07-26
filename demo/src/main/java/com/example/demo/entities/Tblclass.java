package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Tblclass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "classid")
    private Long classid;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "note")
    private String note;

//    @OneToMany(mappedBy = "tblclassByClassid")
//    @JsonIgnore
//    private List<Student> studentsByClassid;

    public Long getClassid() {
        return classid;
    }

    public void setClassid(Long classid) {
        this.classid = classid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tblclass tblclass = (Tblclass) o;
        return classid == tblclass.classid && Objects.equals(name, tblclass.name) && Objects.equals(note, tblclass.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classid, name, note);
    }

//    public List<Student> getStudentsByClassid() {
//        return studentsByClassid;
//    }
//
//
//    public void setStudentsByClassid(List<Student> studentsByClassid) {
//        this.studentsByClassid = studentsByClassid;
//    }
}
