package com.example.product.model;

import java.math.BigDecimal;
//Product
public class Product {
    private long id;
    private String name;
    private BigDecimal price;
    private int stock;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Product(long id, String name, BigDecimal price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
