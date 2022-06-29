package com.demo.CustomerRegister.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("address")
    private String address;
    
    @ManyToOne
    @JoinColumn(name="company_id")
    @JsonIgnore
    private Company company;
    @JsonProperty("companyName")
    public String getCompanyName(){
        return this.company.getName();
    }
    @JsonProperty("companyPhoneNumber")
    public String getCompanyPhoneNumber(){
        return this.company.getPhoneNumber();
    }
}
