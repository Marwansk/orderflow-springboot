package com.example.product.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class ProductUpdateDTO {

    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    private BigDecimal price;

    @NotNull
    @PositiveOrZero
    private Integer stock;

    public ProductUpdateDTO() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}