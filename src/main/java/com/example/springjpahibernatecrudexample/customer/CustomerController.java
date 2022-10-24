package com.example.springjpahibernatecrudexample.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers){
        return service.addCustomers(customers);
    }

    @GetMapping("/customerById/{id}")
    public Customer findCustomerById(@PathVariable int id){
        return service.getCustomerById(id);
    }

    @GetMapping("/customers")
    private List<Customer> findAllCustomers(){
        return service.getCustomers();
    }

    @GetMapping("/customerByName{Firstname}")
    public Customer findCustomerByFirstName(@PathVariable String Firstname){
        return service.getCustomerByFirstName(Firstname);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id){
        return service.deleteCustomer(id);
    }

    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer){
        return service.updateCustomer(customer);
    }
}

