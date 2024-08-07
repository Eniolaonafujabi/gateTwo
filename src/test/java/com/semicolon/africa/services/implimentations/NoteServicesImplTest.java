package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.repositories.NoteRepo;
import com.semicolon.africa.dtos.request.AddNoteRequest;
import com.semicolon.africa.dtos.request.DeleteNoteRequest;
import com.semicolon.africa.dtos.request.FindNoteRequest;
import com.semicolon.africa.dtos.request.UpdateNoteRequest;
import com.semicolon.africa.dtos.response.AddNoteResponse;
import com.semicolon.africa.dtos.response.DeleteNoteResponse;
import com.semicolon.africa.dtos.response.FindNoteResponse;
import com.semicolon.africa.dtos.response.UpdateNoteResponse;
import com.semicolon.africa.exception.NoteException;
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

    private AddNoteResponse createNote() {
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("Title");
        request.setContent("Content");
        AddNoteResponse response = noteServices.createNote(request);
        return response;
    }

    @Test
    public void testAddNote() {
        AddNoteResponse response = createNote();
        assertThat(response.getMessage()).contains("Successfully created note");
    }

    @Test
    public void testThatICanCreateNoteAndNotCreateNoteWithSameTitle() {
        AddNoteResponse response = createNote();
        assertThat(response.getMessage()).contains("Successfully created note");
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("Title");
        request.setContent("Content");
        assertThrows(NoteException.class,()->noteServices.createNote(request));
    }

    @Test
    public void testThatICanUpdateNoteAndNotCreateNoteWithSameTitle() {
        AddNoteResponse response = createNote();
        UpdateNoteRequest request = new UpdateNoteRequest();
        request.setId(response.getId());
        request.setTitle("Title");
        request.setContent("Content");
        assertThrows(NoteException.class,()->noteServices.updateNote(request));
    }

    @Test
    public void testThatICanUpdateNoteWithoutTitleAndStillHaveTheOldTitle(){
        AddNoteResponse response = createNote();
        UpdateNoteRequest request = new UpdateNoteRequest();
        request.setId(response.getId());
        request.setId(response.getId());
        request.setTitle("");
        request.setContent("Content");
        UpdateNoteResponse responce = noteServices.updateNote(request);
        assertThat(responce.getTitle()).contains("Title");
    }

    @Test
    public void testThatICan_ntCreateWithoutTitleThrowsException(){
        AddNoteRequest request = new AddNoteRequest();
        request.setTitle("   ");
        request.setContent("Content");
        assertThrows(NoteException.class,()->noteServices.createNote(request));
    }

    @Test
    public void testThatICanCreateNoteFindNoteAndDeleteNoteById(){
        AddNoteResponse response = createNote();
        DeleteNoteRequest request = new DeleteNoteRequest();
        request.setId(response.getId());
        DeleteNoteResponse response1 = noteServices.deleteNoteById(request);
        assertThat(response1.getMessage()).contains("Deleted");
    }

    @Test
    public void testThatICanCreateNoteFindNoteAndDeleteNoteByTitle(){
        AddNoteResponse response = createNote();
        DeleteNoteRequest request = new DeleteNoteRequest();
        request.setTitle("Title");
        DeleteNoteResponse response1 = new DeleteNoteResponse();
        response1 = noteServices.deleteNoteByTitle(request);
        assertThat(response1.getMessage()).contains("Deleted");
    }

    @Test
    public void testThatIfIDeleteByWrongTitleThrowsException(){
        AddNoteResponse response = createNote();
        DeleteNoteRequest request = new DeleteNoteRequest();
        request.setTitle("Tittle");
        assertThrows(IllegalArgumentException.class,()->noteServices.deleteNoteById(request));
    }

    @Test
    public void testThatICanFindById(){
       AddNoteResponse response = createNote();
       FindNoteRequest request = new FindNoteRequest();
       request.setId(response.getId());
       FindNoteResponse response1 = noteServices.findById(request);
       assertThat(response1.getMessage()).contains("Found");
    }

    @Test
    public void testThatICanFindByTitle(){
        createNote();
        FindNoteRequest request = new FindNoteRequest();
        request.setTitle("Title");
        FindNoteResponse response1 = noteServices.findByTitle(request);
        assertThat(response1.getMessage()).contains("Found");
    }
}