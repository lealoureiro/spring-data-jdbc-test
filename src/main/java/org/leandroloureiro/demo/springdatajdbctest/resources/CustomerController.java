package org.leandroloureiro.demo.springdatajdbctest.resources;


import org.leandroloureiro.demo.springdatajdbctest.model.Customer;
import org.leandroloureiro.demo.springdatajdbctest.repositories.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Customer>> getAllUsers() {

        return ResponseEntity.ok(customerRepository.findAll());

    }

}
