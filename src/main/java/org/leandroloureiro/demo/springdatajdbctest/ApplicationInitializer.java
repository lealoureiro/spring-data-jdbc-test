package org.leandroloureiro.demo.springdatajdbctest;

import org.leandroloureiro.demo.springdatajdbctest.model.Customer;
import org.leandroloureiro.demo.springdatajdbctest.repositories.CustomerRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.Arrays.asList;

@Component
public class ApplicationInitializer implements ApplicationRunner {

    private final CustomerRepository customerRepository;

    public ApplicationInitializer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) {

        Customer customer1 = new Customer("Leandro Loureiro");
        Customer customer2 = new Customer("Ada Lovelace");
        Customer customer3 = new Customer("Alan Turing");
        Customer customer4 = new Customer("Dennis Ritchie");

        customerRepository.saveAll(asList(customer1, customer2, customer3, customer4));

    }

}
