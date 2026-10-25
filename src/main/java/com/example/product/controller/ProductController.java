package com.example.product.controller;
import com.example.product.dto.ProductCreateDTO;
import com.example.product.dto.ProductUpdateDTO;
import jakarta.validation.Valid;
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


    @PostMapping
    public Product createProduct(
            @Valid @RequestBody ProductCreateDTO request) {

        Product product = new Product(
                request.getId(),
                request.getName(),
                request.getPrice(),
                request.getStock()
        );

        return productService.createProduct(product);
    }


    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductUpdateDTO request) {

        Product product = new Product(
                id,
                request.getName(),
                request.getPrice(),
                request.getStock()
        );

        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }//end deleteProduct

}
