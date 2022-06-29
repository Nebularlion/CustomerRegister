package com.demo.CustomerRegister.controller;

import com.demo.CustomerRegister.model.Company;
import com.demo.CustomerRegister.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("companies")
    @CrossOrigin("http://localhost:4200")
    public Iterable<Company> getCompanies(){
        return companyRepository.findAll();
    }

}
