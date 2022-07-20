package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "subjects")
@Data
public class Subjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name") private String name;

    @Column(name = "description") private String description;

    @Column(name = "sem") private int sem;

    @Column(name = "duration") private int duration;

}
