package com.demo.CustomerRegister.repository;

import com.demo.CustomerRegister.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository  extends CrudRepository<Company, Long> {
}
