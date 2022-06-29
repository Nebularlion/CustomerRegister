package com.demo.CustomerRegister.controller;
import com.demo.CustomerRegister.model.Company;
import com.demo.CustomerRegister.model.Customer;
import com.demo.CustomerRegister.model.dto.CustomerCreationDTO;
import com.demo.CustomerRegister.repository.CompanyRepository;
import com.demo.CustomerRegister.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerRegisterController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("customers")
    @CrossOrigin("http://localhost:4200")
    public Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping("addcustomer")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<Void> addUser(@RequestBody CustomerCreationDTO customerDTO) {
        Customer customerToBeSaved = new Customer();
        customerToBeSaved.setFirstName(customerDTO.getFirstName());
        customerToBeSaved.setLastName(customerDTO.getLastName());
        customerToBeSaved.setAddress(customerDTO.getAddress());

        Optional<Company> optionalCompany = companyRepository.findById(customerDTO.getCompanyId());
        if(optionalCompany.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        customerToBeSaved.setCompany(optionalCompany.get());
        customerRepository.save(customerToBeSaved);
        return ResponseEntity.ok().build();
    }
}
