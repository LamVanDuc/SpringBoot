package com.example.demo.dto;

import com.example.demo.entities.Student;

import java.util.List;

public class ListStudent {
    private List<Student>  data;

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }
}
