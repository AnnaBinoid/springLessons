package com.example.sem04task04.controllers;

import com.example.sem04task04.model.Product;
import com.example.sem04task04.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products",
                productService.getAllProducts());
        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(Product p, Model model){
        productService.addProduct(p);
        model.addAttribute("products",
                productService.getAllProducts());
        return "products";
    }
}
