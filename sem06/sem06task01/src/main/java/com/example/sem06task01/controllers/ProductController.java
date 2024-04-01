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

    //в данном случае подтягивается интерфейс
    // , и только на этапе сборки проекта
    // Spring определит,
    private final ProductService productService;

    //ResponseEntity - позволяет изменять статус ответа
    //ошибки, которая может возникнуть в результате.
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
    // если не найдем айдишник - направим сообщение.
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

    // возвратное значение войд. Считается, что при конструировании АПИ
    // всегда должен возвращаться ответ, даже если ничего не возвращается.
    // В данном случае класс Void значит, что возвращается пустой ответ
    // статус с пустым телом.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
