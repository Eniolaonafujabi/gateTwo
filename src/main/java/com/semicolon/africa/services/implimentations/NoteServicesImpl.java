package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.models.Note;
import com.semicolon.africa.data.repositories.NoteRepo;
import com.semicolon.africa.dtos.request.AddNoteRequest;
import com.semicolon.africa.dtos.request.DeleteNoteRequest;
import com.semicolon.africa.dtos.response.AddNoteResponse;
import com.semicolon.africa.dtos.response.DeleteNoteResponse;
import com.semicolon.africa.dtos.response.UpdateNoteResponce;
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
        map(request,note);
        noteRepo.save(note);
        AddNoteResponse response = new AddNoteResponse();
        map(response,note);
        return response;
    }

    @Override
    public UpdateNoteResponce updateNote(AddNoteRequest request) {
        return null;
    }

    @Override
    public DeleteNoteResponse deleteNoteByTitle(DeleteNoteRequest request) {
        return null;
    }

    @Override
    public DeleteNoteResponse deleteNoteById(DeleteNoteRequest request) {
        return null;
    }
}
