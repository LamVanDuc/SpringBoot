package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class Marks {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
//    @Basic
//    @Column(name = "idStudent")
//    private Integer idStudent;
//    @Basic
//    @Column(name = "idSubject")
//    private Integer idSubject;
    @Basic
    @Column(name = "mark")
    private Float mark;
    @Basic
    @Column(name = "Note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "idStudent", referencedColumnName = "id")
    private Student studentByIdStudent;


    @ManyToOne
    @JoinColumn(name = "idSubject", referencedColumnName = "id")
    private Subjects subjectsByIdSubject;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Integer getIdStudent() {
//        return idStudent;
//    }
//
//    public void setIdStudent(Integer idStudent) {
//        this.idStudent = idStudent;
//    }
//
//    public Integer getIdSubject() {
//        return idSubject;
//    }
//
//    public void setIdSubject(Integer idSubject) {
//        this.idSubject = idSubject;
//    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Marks marks = (Marks) o;
//        return id == marks.id && Objects.equals(idStudent, marks.idStudent) && Objects.equals(idSubject, marks.idSubject) && Objects.equals(mark, marks.mark) && Objects.equals(note, marks.note);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, idStudent, idSubject, mark, note);
//    }

//    public Student getStudentByIdStudent() {
//        return studentByIdStudent;
//    }
//
//    public void setStudentByIdStudent(Student studentByIdStudent) {
//        this.studentByIdStudent = studentByIdStudent;
//    }

    public Subjects getSubjectsByIdSubject() {
        return subjectsByIdSubject;
    }

    public void setSubjectsByIdSubject(Subjects subjectsByIdSubject) {
        this.subjectsByIdSubject = subjectsByIdSubject;
    }

}
