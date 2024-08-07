package com.semicolon.africa.controller;

import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.*;
import com.semicolon.africa.services.interfaces.NoteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping
public class NoteController {

    private final NoteServices noteServices;

    @Autowired
    public NoteController(NoteServices noteServices) {
        this.noteServices = noteServices;
    }

    @PostMapping("create")
    public ResponseEntity<?> createNote(@RequestBody AddNoteRequest addNoteRequest) {
        try {
            AddNoteResponse response = noteServices.createNote(addNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true,response),CREATED);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @PatchMapping("/updateNote")
    public ResponseEntity<?> updateNote(@RequestBody UpdateNoteRequest updateNoteRequest) {
        try {
            UpdateNoteResponse response = noteServices.updateNote(updateNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findNoteById/{id}")
    public ResponseEntity<?> findNoteById(@PathVariable("id") String id) {
        FindNoteRequest request = new FindNoteRequest();
        request.setId(id);
        try {
            FindNoteResponse response = noteServices.findById(request);
            return new ResponseEntity<>(new ApiResponse(true,response),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findNoteByTitle/{title}")
    public ResponseEntity<?> findNoteByTitle(@PathVariable("title") String title) {
        FindNoteRequest request = new FindNoteRequest();
        request.setTitle(title);
        try {
            FindNoteResponse response = noteServices.findByTitle(request);
            return new ResponseEntity<>(new ApiResponse(true,response),FOUND);
        }catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteById/{id}")
    ResponseEntity<?> deleteNoteById(@PathVariable("id") String id) {
        DeleteNoteRequest request = new DeleteNoteRequest();
        request.setId(id);
        try {
            DeleteNoteResponse response = noteServices.deleteNoteById(request);
            return new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(true,exception),BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteByTitle/{title}")
    ResponseEntity<?> deleteNoteByTitle(@PathVariable("title") String title) {
        DeleteNoteRequest request = new DeleteNoteRequest();
        request.setTitle(title);
        try {
            DeleteNoteResponse response = noteServices.deleteNoteByTitle(request);
            return new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(true,exception),BAD_REQUEST);
        }
    }
}