package com.example.productpage.model;

public class Product {
    private String imageUrl;
    private String name;
    private double price;
    private int stock;

    public Product(String imageUrl, String name, double price, int stock) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters and Setters
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
