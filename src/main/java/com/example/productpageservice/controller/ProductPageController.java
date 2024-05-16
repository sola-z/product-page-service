package com.example.productpage.controller;

import com.example.productpage.model.Product;
import com.example.productpage.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductPageController {

    @Autowired
    private ProductService productService;

    @GetMapping("/api/products")
    public List<Product> getProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "15") int size) {
        size = Math.min(size, 30); // Maximum 30 items per page
        return productService.getProducts(page, size);
    }
}
