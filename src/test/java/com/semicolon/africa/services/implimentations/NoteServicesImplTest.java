package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.models.Note;
import com.semicolon.africa.data.repositories.NoteRepo;
import com.semicolon.africa.dtos.request.AddNoteRequest;
import com.semicolon.africa.dtos.response.AddNoteResponse;
import com.semicolon.africa.services.interfaces.NoteServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NoteServicesImplTest {

    @Autowired
    private NoteServices noteServices;

    @Autowired
    private NoteRepo repo;

    @BeforeEach
    void setUp() {
        repo.deleteAll();
    }

    @Test
    public void testAddNote() {
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("Title");
        request.setContent("Content");
        AddNoteResponse response = noteServices.createNote(request);
        assertThat(response.getMessage()).contains("Successfully created note");
    }
}