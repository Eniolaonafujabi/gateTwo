package com.semicolon.africa.services.interfaces;

import com.semicolon.africa.dtos.request.AddNoteRequest;
import com.semicolon.africa.dtos.request.DeleteNoteRequest;
import com.semicolon.africa.dtos.request.FindNoteRequest;
import com.semicolon.africa.dtos.request.UpdateNoteRequest;
import com.semicolon.africa.dtos.response.AddNoteResponse;
import com.semicolon.africa.dtos.response.DeleteNoteResponse;
import com.semicolon.africa.dtos.response.FindNoteResponse;
import com.semicolon.africa.dtos.response.UpdateNoteResponse;


public interface NoteServices {

    AddNoteResponse createNote(AddNoteRequest request);

    UpdateNoteResponse updateNote(UpdateNoteRequest request);

    FindNoteResponse findById(FindNoteRequest request);

    FindNoteResponse findByTitle(FindNoteRequest request);

    DeleteNoteResponse deleteNoteByTitle(DeleteNoteRequest request);

    DeleteNoteResponse deleteNoteById(DeleteNoteRequest request);
}
