package com.example.sem06task01.services;

import com.example.sem06task01.domain.Product;

import java.util.List;

/**
 * � �������������� ����� ���������� ����� ��������.
 * �.�. ���� ��������� - �������������� ������������� �������
 * ����� �������� � ������������.
 * ��������� ����� ����� ������� ����-�� ���������� ��������,
 * ������������� ���������.
 */
public interface ProductService {
    List<Product> getAllProducts();
    Product getProductByID(Long id);
    Product updateProduct(Product product);
    Product createProduct(Product product);
    void deleteProduct(Long id);
}
