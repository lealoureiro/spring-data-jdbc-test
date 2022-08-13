package org.leandroloureiro.demo.springdatajdbctest;

import org.leandroloureiro.demo.springdatajdbctest.model.Customer;
import org.leandroloureiro.demo.springdatajdbctest.model.Note;
import org.leandroloureiro.demo.springdatajdbctest.repositories.CustomerRepository;
import org.leandroloureiro.demo.springdatajdbctest.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import static java.util.Arrays.asList;

@Service
public class DatabaseInitializerService {

    private final CustomerRepository customerRepository;
    private final NoteRepository noteRepository;

    public DatabaseInitializerService(CustomerRepository customerRepository,
                                  NoteRepository noteRepository) {
        this.customerRepository = customerRepository;
        this.noteRepository = noteRepository;
    }

    public void initDatabase() {

        Customer customer1 = new Customer("Leandro Loureiro");
        Customer customer2 = new Customer("Ada Lovelace");
        Customer customer3 = new Customer("Alan Turing");
        Customer customer4 = new Customer("Dennis Ritchie");

        customerRepository.saveAll(asList(customer1, customer2, customer3, customer4));

        Note note1 = new Note("some random text 1", customer1.getId());
        Note note2 = new Note("some random text 2", customer2.getId());
        Note note3 = new Note("some random text 3", customer2.getId());
        Note note4 = new Note("some random text 4", customer4.getId());

        noteRepository.saveAll(asList(note1, note2, note3, note4));

    }

}
