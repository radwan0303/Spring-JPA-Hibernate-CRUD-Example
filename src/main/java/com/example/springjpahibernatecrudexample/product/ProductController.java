package com.example.springjpahibernatecrudexample.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class ProductController {

    //Denne controller skal snakke med service class
    @Autowired
    private ProductService service;

    //@RequestBody så JSON input kan blive sat i Product Objekt
    //Disse er min Post derfor annoteres de med PostMapping
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.addProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.addProducts(products);
    }

    //Disse er min Get derfor annoteres de med GetMapping
    @GetMapping("/products")
    private List<Product> findAllProducts(){
        return service.getProducts();
    }

    //@Pathvariable eftersom at det f.eks er id der skal sættes i URL for at finde den eftersøgte id
    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/products{name}")
    public Product findProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }


}
