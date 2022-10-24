package com.example.springjpahibernatecrudexample.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
       Customer findByFirstName(String Firstname);

        }


