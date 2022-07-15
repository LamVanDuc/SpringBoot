package com.example.demo.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name") private String hoten;

    @Column(name = "address") private String diachi;

    @Column(name = "phonenumber") private String sodt;

    @Column(name = "email") private String email;


}
