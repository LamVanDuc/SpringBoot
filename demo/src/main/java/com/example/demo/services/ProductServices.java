package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.entities.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductServices {
    List<Product> getAllProduct();

    ResponseEntity<ResponseObject> findById(Long id);


    ResponseEntity<ResponseObject> findByName(String name);


    ResponseEntity<ResponseObject> insertProduct(Product Product);

    ResponseEntity<ResponseObject> updateProduct(Long id , Product newProduct);

    ResponseEntity<ResponseObject> deleteProduct(Long id);

}
