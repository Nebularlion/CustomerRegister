package com.demo.CustomerRegister.controller;
import com.demo.CustomerRegister.model.Customer;
import com.demo.CustomerRegister.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerRegisterController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("customers")
    @CrossOrigin("http://localhost:4200")
    public Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }
}
