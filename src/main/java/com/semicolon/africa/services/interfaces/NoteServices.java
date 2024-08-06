package com.semicolon.africa.services.interfaces;

import com.semicolon.africa.dtos.request.AddNoteRequest;
import com.semicolon.africa.dtos.request.DeleteNoteRequest;
import com.semicolon.africa.dtos.response.AddNoteResponse;
import com.semicolon.africa.dtos.response.DeleteNoteResponse;
import com.semicolon.africa.dtos.response.UpdateNoteResponce;


public interface NoteServices {

    AddNoteResponse createNote(AddNoteRequest request);

    UpdateNoteResponce updateNote(AddNoteRequest request);

    DeleteNoteResponse deleteNoteByTitle(DeleteNoteRequest request);

    DeleteNoteResponse deleteNoteById(DeleteNoteRequest request);
}
