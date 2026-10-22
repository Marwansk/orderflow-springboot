package com.example.product.controller;

import com.example.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
//
@RestController//permette a spring di gestire richieste rest
@RequestMapping("/api/products")
public class ProductController {
    @GetMapping//è un'annotazione di Spring Boot che serve a collegare una richiesta HTTP GET a un metodo Java.
//List<product> indica che il metodo restituisce una lista di prodotti
    public List<Product> getAllProducts(){
        Product mouse=new Product(1L, "Mouse", new BigDecimal("19.99"),10);
        Product Keyboard=new Product(1L,"Keyboard", new BigDecimal("25.99"),14);
    return List.of(mouse,Keyboard);//creo lista contenente il prodotto mouse
    }//end metodo
}
