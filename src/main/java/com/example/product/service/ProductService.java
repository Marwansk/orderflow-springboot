package com.example.product.service;
import com.example.product.model.Product;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
@Service//service serve per dire a spring che questa classe e la logica applicativa

public class ProductService {
private final List<Product> products=new ArrayList<>();


    public ProductService() {
    products.add(new Product(1L,"Mouse",new BigDecimal("19.99"),10));
    products.add(new Product(2L, "Keyboard", new BigDecimal("11.99"), 30));
    }





}//end productservice
