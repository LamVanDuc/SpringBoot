package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Basic
    @Column(name = "email")
    private String email;

//    @OneToOne
//    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
//    private Student studentById;
//    @OneToOne(mappedBy = "studentById")
//    private Student studentById_0;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "classid", referencedColumnName = "classid")
    private Tblclass tblclassByClassid;

//    @Basic
//    @Column(name = "classid")
//    private Integer classid;

    @JsonIgnore
    @OneToMany(mappedBy = "studentByIdStudent")
    private List<Marks> marksById;
//    @OneToOne
//    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
//    private Student studentById;
//    @OneToOne(mappedBy = "studentById")
//    private Student studentById_0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public Integer getClassid() {
//        return classid;
//    }
//
//    public void setClassid(Integer classid) {
//        this.classid = classid;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return id == student.id && Objects.equals(name, student.name) && Objects.equals(address, student.address) && Objects.equals(phoneNumber, student.phoneNumber) && Objects.equals(email, student.email) && Objects.equals(classid, student.classid);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, address, phoneNumber, email, classid);
//    }

//    public Student getStudentById() {
//        return studentById;
//    }
//
//    public void setStudentById(Student studentById) {
//        this.studentById = studentById;
//    }
//
//    public Student getStudentById_0() {
//        return studentById_0;
//    }
//
//    public void setStudentById_0(Student studentById_0) {
//        this.studentById_0 = studentById_0;
//    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Tblclass getTblclassByClassid() {
        return tblclassByClassid;
    }

    public void setTblclassByClassid(Tblclass tblclassByClassid) {
        this.tblclassByClassid = tblclassByClassid;
    }

//    public Integer getClassid() {
//        return classid;
//    }
//
//    public void setClassid(Integer classid) {
//        this.classid = classid;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(address, student.address) && Objects.equals(phoneNumber, student.phoneNumber) && Objects.equals(email, student.email) && Objects.equals(classid, student.classid);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, address, phoneNumber, email, classid);
//    }

    public Collection<Marks> getMarksById() {
        return marksById;
    }

    public void setMarksById(List<Marks> marksById) {
        this.marksById = marksById;
    }

//    public Student getStudentById() {
//        return studentById;
//    }
//
//    public void setStudentById(Student studentById) {
//        this.studentById = studentById;
//    }
//
//    public Student getStudentById_0() {
//        return studentById_0;
//    }
//
//    public void setStudentById_0(Student studentById_0) {
//        this.studentById_0 = studentById_0;
//    }
}
