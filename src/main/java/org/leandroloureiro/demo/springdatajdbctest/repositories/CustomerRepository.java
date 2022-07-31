package org.leandroloureiro.demo.springdatajdbctest.repositories;

import org.leandroloureiro.demo.springdatajdbctest.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository <Customer, String> {

    List<Customer> findAll();

}