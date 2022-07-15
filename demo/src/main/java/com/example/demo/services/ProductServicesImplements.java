package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.entities.ResponseObject;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicesImplements implements ProductServices{
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public ResponseEntity<ResponseObject> findById(Long id) {
        Optional<Product> findProduct = productRepository.findById(id);
        return findProduct.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok" ,"query product successfully" , findProduct))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false" , "Cannot find product id ="+id ,""));
    }

    @Override
    public ResponseEntity<ResponseObject> findByName(String name) {
        List<Product> findProduct = productRepository.findProductByProName(name);
        return !findProduct.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok" ,"query product successfully" , findProduct))
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("false" , "Cannot find product name ="+name ,""));
    }

    @Override
    public ResponseEntity<ResponseObject> insertProduct(Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseObject("ok" , "insert product successfully" , productRepository.save(product)));
    }

    @Override
    public ResponseEntity<ResponseObject> updateProduct(Long id , Product newProduct) {
        Product findProduct = productRepository.findById(id).map(product -> {
            product.setProName(newProduct.getProName());
            product.setProDesc(newProduct.getProDesc());
            product.setPrice(newProduct.getPrice());
            return productRepository.save(product);
        }).orElseGet(()->{
            newProduct.setId(id);
            return productRepository.save(newProduct);
        });
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok" , "update product successfully" , findProduct));
    }

    @Override
    public ResponseEntity<ResponseObject> deleteProduct(Long id) {
        boolean exitProduct = productRepository.existsById(id);
        if (exitProduct){
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok" , "delete product successfully",exitProduct));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("false" ,"Cannot product by id = "+id,""));
        }
    }
}
