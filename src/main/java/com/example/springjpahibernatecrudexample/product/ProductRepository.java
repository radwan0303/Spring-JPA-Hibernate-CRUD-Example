package com.example.springjpahibernatecrudexample.product;
import org.springframework.data.jpa.repository.JpaRepository;
// Vi sørger for at arve fra JPA så vi får alle dens metoder.
// Vi skriver vores model navn i, som er Porduct, samt PK´s datatype, som er Integer

public interface ProductRepository extends JpaRepository<Product, Integer> {

    //Metoden vi selv har lavet for at finde et produkt via dens navn
    Product findByName(String name);

}
