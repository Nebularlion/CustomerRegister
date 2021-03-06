package com.demo.CustomerRegister.controller;

import com.demo.CustomerRegister.model.Customer;
import com.demo.CustomerRegister.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Resource> getCSV() {
        try {
            final Iterable<Customer> customers = customerRepository.findAll();
            final CsvMapper mapper = new CsvMapper();
            mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN,true);
            CsvSchema schema = CsvSchema.builder()
                    .setUseHeader(true)
                    .addColumn("firstName")
                    .addColumn("lastName")
                    .addColumn("address")
                    .addColumn("companyName")
                    .addColumn("companyPhoneNumber")
                    .build();
            String csv = mapper.writer(schema).writeValueAsString(customers);
            byte[] csvBytes = csv.getBytes();
            ByteArrayResource resource = new ByteArrayResource(csvBytes);

            return ResponseEntity.ok()
                    .contentLength(csvBytes.length)
                    .header("Content-Disposition", "attachment; filename=customers.csv")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);

        } catch (JsonProcessingException e){
            System.out.println("Exception occurred: " + e);
            return ResponseEntity.status(500).build();
        }
    }
}
