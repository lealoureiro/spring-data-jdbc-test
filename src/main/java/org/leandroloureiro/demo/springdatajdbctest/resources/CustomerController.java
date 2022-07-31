package org.leandroloureiro.demo.springdatajdbctest.resources;


import org.leandroloureiro.demo.springdatajdbctest.model.Customer;
import org.leandroloureiro.demo.springdatajdbctest.model.CustomerRequest;
import org.leandroloureiro.demo.springdatajdbctest.repositories.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Customer>> getAllCustomers() {

        return ResponseEntity.ok(customerRepository.findAll());

    }

    @GetMapping(path = "/customer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Customer> getCustomer(@PathVariable UUID id) {

        return customerRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping(path = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerRequest customer) {

        return ResponseEntity.ok(customerRepository.save(new Customer(customer.name())));

    }

    @PutMapping(path = "/customer/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Customer> updateCustomer(@PathVariable UUID id, @Valid @RequestBody CustomerRequest customer) {

        if (customerRepository.existsById(id)) {

            return ResponseEntity.ok(customerRepository.save(new Customer(id, customer.name())));

        } else {

            return ResponseEntity.notFound().build();

        }

    }

    @DeleteMapping(path = "/customer/{id}")
    ResponseEntity<Void> deleteCustomer(@PathVariable UUID id) {

        if (customerRepository.existsById(id)) {

            customerRepository.deleteById(id);

            return ResponseEntity.noContent().build();

        } else {

            return ResponseEntity.notFound().build();

        }

    }

}
