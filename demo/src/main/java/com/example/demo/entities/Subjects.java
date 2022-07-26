package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "subjects")
@Data
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name") private String name;
    @Basic
    @Column(name = "description") private String description;
    @Basic
    @Column(name = "sem") private int sem;
    @Basic
    @Column(name = "duration") private int duration;

    @JsonIgnore
    @OneToMany(mappedBy = "subjectsByIdSubject")
    private Collection<Marks> marksById;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSem() {
        return sem;
    }

    public void setSem(Integer sem) {
        this.sem = sem;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subjects subjects = (Subjects) o;
        return sem == subjects.sem && duration == subjects.duration && Objects.equals(id, subjects.id) && Objects.equals(name, subjects.name) && Objects.equals(description, subjects.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, sem, duration);
    }

    public Collection<Marks> getMarksById() {
        return marksById;
    }

    public void setMarksById(Collection<Marks> marksById) {
        this.marksById = marksById;
    }
}
