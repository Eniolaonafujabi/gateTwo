package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepo extends MongoRepository<Note, String> {
}
