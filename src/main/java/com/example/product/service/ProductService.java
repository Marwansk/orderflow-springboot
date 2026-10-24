package com.example.product.service;
import com.example.product.model.Product;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
@Service//service serve per dire a spring che questa classe e la logica applicativa

public class ProductService {
private final List<Product> products=new ArrayList<>();


    public ProductService() {
    products.add(new Product(1L,"Mouse",new BigDecimal("19.99"),10));
    products.add(new Product(2L, "Keyboard", new BigDecimal("11.99"), 30));
    }

public List<Product> getAllProducts() {
        return products;
}//end getallproduct

    public Product getProductById(Long id) {
        for (Product p :products) {
            if(p.getId()==id){
            return p;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"prodotto non trovato");
    }//end getProductByid

public Product createProduct(Product product){
        products.add(product);
        return product;
}//end createProduct

    public Product updateProduct(Long id, Product updateProduct){
        for (Product p:products) {
            if(p.getId()==id){
                p.setName(updateProduct.getName());
                p.setPrice(updateProduct.getPrice());
                p.setStock(updateProduct.getStock());
                return p;
            }
        }
        throw  new ResponseStatusException(
                HttpStatus.NOT_FOUND,"Prodotto non trovato"
        );

    }//end updateProduct

public void  deleteProduct(@PathVariable Long id) {
        for(Product p :products){
            if(p.getId()==id){
                products.remove(p);
                return;
            }
        }
    throw  new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Prodotto non esiste");
}//end deleteproduct






}//end productservice
