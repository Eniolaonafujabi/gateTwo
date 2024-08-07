package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NoteRepo extends MongoRepository<Note, String> {
    boolean existsByTitle(String title);

    Optional<Note> findByTitle(String title);
}
