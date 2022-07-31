package org.leandroloureiro.demo.springdatajdbctest.repositories;

import org.leandroloureiro.demo.springdatajdbctest.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

    List<Customer> findAll();

}
