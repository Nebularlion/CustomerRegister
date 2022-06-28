package com.demo.CustomerRegister.config;
import com.demo.CustomerRegister.model.Company;
import com.demo.CustomerRegister.model.Customer;
import com.demo.CustomerRegister.repository.CompanyRepository;
import com.demo.CustomerRegister.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInsertRunner implements CommandLineRunner {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void run(String... args) {
        Company company = new Company();
        company.setName("Test company");
        company.setPhoneNumber("04412345678");

        Company savedCompany = companyRepository.save(company);

        Customer customer = new Customer();
        customer.setFirstName("Test");
        customer.setLastName("Tester");
        customer.setAddress("Testroad 1");
        customer.setCompany(savedCompany);

        Customer customer2 = new Customer();
        customer2.setFirstName("Customer");
        customer2.setLastName("Testcustomer");
        customer2.setAddress("Testroad 2");
        customer2.setCompany(savedCompany);

        customerRepository.save(customer);
        customerRepository.save(customer2);
    }
}
