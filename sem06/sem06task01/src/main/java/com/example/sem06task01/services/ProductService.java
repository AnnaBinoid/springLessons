package com.example.sem06task01.services;

import com.example.sem06task01.domain.Product;

import java.util.List;

/**
 * С имплементацией этого интерфейса будет надежнее.
 * Т.к. этот интерфейс - дополнительная архитектурная граница
 * между сервисом и контролерами.
 * Благодаря этому можем создать неск-ко реализаций сервисов,
 * имплементируя интерфейс.
 */
public interface ProductService {
    List<Product> getAllProducts();
    Product getProductByID(Long id);
    Product updateProduct(Product product);
    Product createProduct(Product product);
    void deleteProduct(Long id);
}
