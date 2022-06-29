package com.demo.CustomerRegister.controller;

import com.demo.CustomerRegister.model.Customer;
import com.demo.CustomerRegister.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CsvController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("exportcsv")
    @CrossOrigin("http://localhost:4200")
    @ResponseBody
    public String getCSV() {
        try {
            final Iterable<Customer> customers = customerRepository.findAll();
            final CsvMapper mapper = new CsvMapper();
            mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);
            CsvSchema schema = CsvSchema.builder()
                    .addColumn("firstName")
                    .addColumn("lastName")
                    .addColumn("address")
                    .addColumn("companyName")
                    .addColumn("companyPhoneNumber")
                    .build();
            String csv = mapper.writer(schema).writeValueAsString(customers);
            System.out.println("csv: " + csv);
            return csv;
        } catch (Exception e){
            System.out.println("Exception occurred: " + e);
            return "";
        }
    }
}
