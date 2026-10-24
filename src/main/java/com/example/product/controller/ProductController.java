package com.example.product.controller;

import com.example.product.service.ProductService;
import com.example.product.model.Product;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController//permette a spring di gestire richieste rest
@RequestMapping("/api/products")//imposta indirizzo base del controller


public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping//Esegue il metodo quando arriva una richiesta GET.
    //List<product> indica che il metodo restituisce una lista di prodotti
    public List<Product> getAllProducts(){
    return productService.getAllProducts();//creo lista contenente il prodotto mouse
    }//end metodo getallproduct


    @GetMapping("/{id}")//gestisce una get con un id nell indirizzo
    //@PathVariable Long id → prende il numero dall'URL e lo salva nella variabile id.
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }//end getProductById


    @PostMapping//riceve richiesta http post.richiede al server di reare una risorsa
    public Product createProduct(@RequestBody Product product){
    //requeest body trasforma il json in oggetto java

            return productService.createProduct(product);
    }//end createproduct


    @PutMapping("/{id}")//put serve ad aggiornar un prodotto gia esistente
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product updatedProduct) {

        return productService.updateProduct(id, updatedProduct);
    }//end updateProduct

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }//end deleteProduct

}
