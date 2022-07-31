package org.leandroloureiro.demo.springdatajdbctest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;

import java.util.UUID;

public class Customer {

    @Id
    private UUID id;

    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @PersistenceCreator
    public Customer(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
