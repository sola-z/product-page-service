package com.example.productpage.service;

import com.example.productpage.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();

    public ProductService() {
        // Initialize with some sample data
        for (int i = 1; i <= 100; i++) {
            products.add(new Product("https://example.com/image" + i + ".jpg", "Product " + i, i * 10.0, i * 10));
        }
    }

    public List<Product> getProducts(int page, int size) {
        int fromIndex = Math.min((page - 1) * size, products.size());
        int toIndex = Math.min(page * size, products.size());
        return products.subList(fromIndex, toIndex);
    }
}
