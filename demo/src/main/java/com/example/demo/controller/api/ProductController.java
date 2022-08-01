package com.example.demo.controller.api;

import com.example.demo.entities.Product;
import com.example.demo.entities.ResponseObject;
import com.example.demo.services.ProductServicesImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired ProductServicesImplements productServicesImplements;



    @GetMapping("") List<Product> getAllProduct(){
        return productServicesImplements.getAllProduct();
    }


    @GetMapping("/{id}") ResponseEntity<ResponseObject> findProductById(@PathVariable Long id){
        return productServicesImplements.findById(id);
    }


    @GetMapping("/query") ResponseEntity<ResponseObject> findProductByName(@RequestParam(value = "name" , required = false)String name){
        return productServicesImplements.findByName(name);
    }


    @PostMapping("/insert") ResponseEntity<ResponseObject> insertProduct(@RequestBody Product product){
        return productServicesImplements.insertProduct(product);
    }


    @PutMapping("/update/{id}") ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct,@PathVariable Long id){
        return productServicesImplements.updateProduct(id, newProduct);
    }


    @DeleteMapping("/delete/{id}") ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id){
        return productServicesImplements.deleteProduct(id);
    }


}
