package com.example.sem06task01.services.impl;

import com.example.sem06task01.domain.Product;
import com.example.sem06task01.repository.ProductRepository;
import com.example.sem06task01.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductByID(Long id) {
        return productRepository.findById(id)
                .orElseThrow(null);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productById = getProductByID(product.getId());

        productById.setCount(product.getCount());
        productById.setName(product.getName());
        productById.setQuantity(product.getQuantity());
        return productRepository.save(productById);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product productById = getProductByID(id);
        productRepository.delete(productById);
    }
}
