package com.example.product.controller;

import com.example.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController//permette a spring di gestire richieste rest
@RequestMapping("/api/products")//imposta indirizzo base del controller


public class ProductController {
    @GetMapping//Esegue il metodo quando arriva una richiesta GET.
//List<product> indica che il metodo restituisce una lista di prodotti
    public List<Product> getAllProducts(){
        Product mouse=new Product(1L, "Mouse", new BigDecimal("19.99"),10);
        Product Keyboard=new Product(2L,"Keyboard", new BigDecimal("25.99"),14);
    return List.of(mouse,Keyboard);//creo lista contenente il prodotto mouse
    }//end metodo getallproduct

    @GetMapping("/{id}")//gestisce una get con un id nell indirizzo
    //@PathVariable Long id → prende il numero dall'URL e lo salva nella variabile id.

    public Product getProductById(@PathVariable Long id){
        List<Product> products=getAllProducts();
        // Scorre i prodotti uno alla volta e restituisce quello con l'ID richiesto
        for (Product p: products){
        if(p.getId()==id) {
            return p;
        }//end if
        }
        return null;
    }//end getProductById

}
