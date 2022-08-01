package org.leandroloureiro.demo.springdatajdbctest.resources;

import org.leandroloureiro.demo.springdatajdbctest.model.Note;
import org.leandroloureiro.demo.springdatajdbctest.repositories.NoteRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping(path = "/customer/{customerId}/note", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Note>> getAllNotesForCustomer(@PathVariable UUID customerId) {

        return ResponseEntity.ok(noteRepository.findAllByCustomerId(customerId));

    }

}
