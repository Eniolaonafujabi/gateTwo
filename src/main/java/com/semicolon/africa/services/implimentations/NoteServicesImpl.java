package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.models.Note;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.semicolon.africa.util.Mapper.map;

@Service
public class NoteServicesImpl implements NoteServices {
    @Autowired
    private  NoteRepo noteRepo;

    @Override
    public AddNoteResponse createNote(AddNoteRequest request) {
        Note note = new Note();
        validateTitle(request.getTitle());
        checkIfTitleExit(request.getTitle());
        validateContent(request.getContent());
        checkRequestState(request);
        map(request,note);
        noteRepo.save(note);
        AddNoteResponse response = new AddNoteResponse();
        map(response,note);
        return response;
    }

    private void validateContent(String content) {
        String newContent = content.trim();
        if (newContent.isEmpty()) {
            throw new NoteException("Content cannot be empty");
        }
    }

    private void validateTitle(String title) {
        String newTitle = title.trim();
        if (newTitle.isEmpty()) {
            throw new NoteException("Title cannot be empty");
        }
    }

    private void checkRequestState(AddNoteRequest request) {
        if (request.getTitle() == null || request.getTitle().equals("")) {
            throw new NoteException("Title is required");
        }
        String title = request.getTitle();
        if (title.trim().isEmpty()) {
            throw new NoteException("Title is required");
        }
    }

    private void checkIfTitleExit(String title) {
        if(noteRepo.existsByTitle(title)) throw new NoteException("Title Already Exit");
    }

    @Override
    public UpdateNoteResponse updateNote(UpdateNoteRequest request) {
        Note note = noteRepo.findById(request.getId())
                .orElseThrow(() -> new NoteException("Note Not Found"));
        checkIfTitleExit(request.getTitle());
        if(request.getTitle() == null || request.getTitle().isEmpty()) note.setTitle(note.getTitle());
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        noteRepo.save(note);
        UpdateNoteResponse response = new UpdateNoteResponse();
        map(response,note);
        return response;
    }

    @Override
    public FindNoteResponse findById(FindNoteRequest request) {
        Note note = findById(request.getId());
        FindNoteResponse response = new FindNoteResponse();
        map(response,note);
        return response;
    }

    private Note findById(String id){
        return noteRepo.findById(id)
                .orElseThrow(() -> new NoteException("Note Not Found"));
    }

    @Override
    public FindNoteResponse findByTitle(FindNoteRequest request) {
        Note note = findByTitle(request.getTitle());
        FindNoteResponse response = new FindNoteResponse();
        map(response,note);
        return response;
    }

    private Note findByTitle(String title){
        return noteRepo.findByTitle(title)
                .orElseThrow(() -> new NoteException("Note Not Found"));
    }

    @Override
    public DeleteNoteResponse deleteNoteByTitle(DeleteNoteRequest request) {
        Note note = findByTitle(request.getTitle());
        noteRepo.delete(note);
        DeleteNoteResponse response = new DeleteNoteResponse();
        response.setMessage("Deleted");
        return response;
    }

    @Override
    public DeleteNoteResponse deleteNoteById(DeleteNoteRequest request) {
        Note note = findById(request.getId());
        noteRepo.delete(note);
        DeleteNoteResponse response = new DeleteNoteResponse();
        response.setMessage("Deleted");
        return response;
    }
}
