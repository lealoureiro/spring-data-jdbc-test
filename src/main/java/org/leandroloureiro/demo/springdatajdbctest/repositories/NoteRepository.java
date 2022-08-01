package org.leandroloureiro.demo.springdatajdbctest.repositories;

import org.leandroloureiro.demo.springdatajdbctest.model.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface NoteRepository extends CrudRepository<Note, UUID> {

    List<Note> findAllByCustomerId(UUID id);

}
