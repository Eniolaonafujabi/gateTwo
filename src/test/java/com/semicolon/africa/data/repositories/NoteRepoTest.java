package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NoteRepoTest {

    @Autowired
    private NoteRepo noteRepo;

    @BeforeEach
    public void setUp() {
        noteRepo.deleteAll();
    }

    @Test
    public void createNote() {
        Note note = new Note();
        noteRepo.save(note);
        assertEquals(noteRepo.count(),1);
    }

    @Test
    public void deleteNote() {
        Note note = new Note();
        noteRepo.save(note);
        noteRepo.delete(note);
        assertEquals(noteRepo.count(),0);
    }
}