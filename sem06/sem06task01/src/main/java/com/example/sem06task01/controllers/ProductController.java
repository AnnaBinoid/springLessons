package com.example.sem06task01.controllers;

import com.example.sem06task01.domain.Product;
import com.example.sem06task01.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    //� ������ ������ ������������� ���������
    // , � ������ �� ����� ������ �������
    // Spring ���������,
    private final ProductService productService;

    //ResponseEntity - ��������� �������� ������ ������
    //������, ������� ����� ���������� � ����������.
    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAllProducts()
                , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product)
                , HttpStatus.CREATED);
    }
    // ���� �� ������ �������� - �������� ���������.
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id")Long id){
        Product productById;
        try {
             productById = productService.getProductByID(id);
        } catch(RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Product());
        }
        return new ResponseEntity<>(productById, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.updateProduct(product),
                HttpStatus.OK);
    }

    // ���������� �������� ����. ���������, ��� ��� ��������������� ���
    // ������ ������ ������������ �����, ���� ���� ������ �� ������������.
    // � ������ ������ ����� Void ������, ��� ������������ ������ �����
    // ������ � ������ �����.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
