package com.example.product.controller;
import com.example.product.service.ProductService;
import com.example.product.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController//permette a spring di gestire richieste rest
@RequestMapping("/api/products")//imposta indirizzo base del controller


public class ProductController {

    private final List<Product> products =new ArrayList<>();

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping//Esegue il metodo quando arriva una richiesta GET.
//List<product> indica che il metodo restituisce una lista di prodotti
    public List<Product> getAllProducts(){
    return products;//creo lista contenente il prodotto mouse
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
         throw new ResponseStatusException(//se il prodotto non esiste
                HttpStatus.NOT_FOUND,"prodotto non trovato"
        );
    }//end getProductById

    @PostMapping//riceve richiesta http post.richiede al server di reare una risorsa
    public Product createProduct(@RequestBody Product product){
    //requeest body trasforma il json in oggetto java
            products.add(product);
        return product;
    }//end createproduct

    @PutMapping("/{id}")//put serve ad aggiornar un prodotto gia esistente
    public Product updateProduct(//serve a modificare un prodotto gia presente nella lista
            @PathVariable Long id,
            @RequestBody Product updatedProduct){
        for (Product p: products){
            if(p.getId()==id) {
                p.setName(updatedProduct.getName());
                p.setPrice(updatedProduct.getPrice());
                p.setStock(updatedProduct.getStock());
                return p;
            }
        }
        throw  new ResponseStatusException(
          HttpStatus.NOT_FOUND,"Prodotto non trovato"
        );
    }//end updateProduct

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        for (Product p :products){
            if(p.getId()==id){
                products.remove(p);
                return;
            }
        }
    throw  new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Prodotto non esiste");
    }//end deleteProduct

}
