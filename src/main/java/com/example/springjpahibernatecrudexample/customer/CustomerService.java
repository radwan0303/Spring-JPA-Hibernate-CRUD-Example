package com.example.springjpahibernatecrudexample.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public String deleteCustomer(int id) {
        repository.deleteById(id);
        return "Customer removed" + id;
    }

    public Customer addCustomer(Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> addCustomers (List<Customer> customers){
        return repository.saveAll(customers);
    }

    public Customer getCustomerById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Customer getCustomerByFirstName(String Firstname) {
        return repository.findByFirstName(Firstname);
    }

    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = repository.findById(customer.getId()).orElse(null);
        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
        existingCustomer.setEmail(customer.getEmail());
        return repository.save(existingCustomer);
    }


}
