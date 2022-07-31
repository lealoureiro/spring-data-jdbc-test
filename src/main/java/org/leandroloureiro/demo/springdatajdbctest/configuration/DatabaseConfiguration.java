package org.leandroloureiro.demo.springdatajdbctest.configuration;

import org.leandroloureiro.demo.springdatajdbctest.model.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;

import java.util.Objects;
import java.util.UUID;

@Configuration
public class DatabaseConfiguration {


    @Bean
    BeforeSaveCallback<Customer> customerBeforeSaveCallback() {

        return (customer, aggregateChange) -> {

            if (Objects.isNull(customer.getId())) {
                customer.setId(UUID.randomUUID());
            }

            return customer;
        };

    }

}
