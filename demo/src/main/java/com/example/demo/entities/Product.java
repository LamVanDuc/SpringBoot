package com.example.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "khong duoc null")
    @NotBlank(message = "khong duoc blank")
    @Column(name = "proName")
    private String proName;

    @NotNull(message = "product description is not null")
    @NotBlank(message = "enter the product description")
    @Column(name = "proDesc")
    private String proDesc;

    @Min(value = -1 , message = "khong nhap so am vao day")
    @NotNull(message = "price is not null")
    @NotBlank(message = "enter the product price")
    @Column(name = "price")
    private double price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", proDesc='" + proDesc + '\'' +
                ", price=" + price +
                '}';
    }


    public Product(String proName, String proDesc, double price) {
        this.proName = proName;
        this.proDesc = proDesc;
        this.price = price;
    }
    public Product(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
