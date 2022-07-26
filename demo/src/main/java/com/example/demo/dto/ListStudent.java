package com.example.demo.dto;

import com.example.demo.entities.Student;

import java.util.List;

public class ListStudent {
    private List<dtoStudent>  data;

    public List<dtoStudent> getData() {
        return data;
    }

    public void setData(List<dtoStudent> data) {
        this.data = data;
    }
}
