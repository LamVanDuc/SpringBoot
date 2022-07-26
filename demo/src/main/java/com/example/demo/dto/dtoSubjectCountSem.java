package com.example.demo.dto;

public class dtoSubjectCountSem {
    private int sem;
    private Long quantity;

    public dtoSubjectCountSem(int sem, Long quantity) {
        this.sem = sem;
        this.quantity = quantity;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
