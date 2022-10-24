package com.example.springjpahibernatecrudexample.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {

    @Autowired
    //Denne Productervice skal snakke med Repository, derfor laver vi et objekt af den og intejtere den ved autowired.
    private ProductRepository repository;

    // PostMethod:
    // Denne metode vil tage product Objektet som argument og gemme den.
    // save() metoden gives af JPA
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    //Hvis man gerne vil kunne gemme en liste af produkter på samme tid:
    public List<Product> addProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    //GetMethod:
    //For at hente product liste objekt fra databasen.

    public List<Product> getProducts() {
        return repository.findAll();
    }

    //GetMethod for at hente et enkelt produkt, derfor finder man den via id:
    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    //Hvis man gerne vil finde et produkt via den navn:
    //Metoden findByName gives ikke af JPA derfor laver vi den selv i ProductRepository
    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    //DeleteMethod:
    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "Product removed: " + id;
    }

    //UpdateMethod:
    //Først henter den produktet og derefter kan vi ændre den, via produkt id
    //orElse null, altså den skal retunere null hvis produktet ikke findes
    //eftersom at der ikke findes nogen updatemethod i jpa, kan vi blot bruge de eksisterende produkter, og derefter saver den.
    //og derefter set dem. Vi gør altså dette for alle products attributer.
    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantiy(product.getQuantiy());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }



}
