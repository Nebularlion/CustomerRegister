package com.demo.CustomerRegister.repository;
import com.demo.CustomerRegister.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
