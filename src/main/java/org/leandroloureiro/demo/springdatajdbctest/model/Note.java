package org.leandroloureiro.demo.springdatajdbctest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

public class Note {

    @Id
    private UUID id;

    private final String text;

    @Column("CUSTOMER_ID")
    @JsonIgnore
    private final UUID customerId;

    public Note(String text, UUID customerId) {
        this.text = text;
        this.customerId = customerId;
    }

    @PersistenceCreator
    public Note(UUID id, String text, UUID customerId) {
        this.id = id;
        this.text = text;
        this.customerId = customerId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public UUID getCustomerId() {
        return customerId;
    }
}
