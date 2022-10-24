package com.example.springjpahibernatecrudexample.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// Lombok annotation, for at genere getters og setters:
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name = "PRODUCT_TABLE")
public class Product {

// Denne Id vil jeg gerne autogenere, derfor denne annotation:
@Id
@GeneratedValue
    private int id;
    private String name;
    private int quantiy;
    private double price;
}
