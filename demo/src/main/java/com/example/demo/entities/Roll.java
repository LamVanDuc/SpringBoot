package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Roll {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roll roll = (Roll) o;
        return id == roll.id && Objects.equals(name, roll.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
