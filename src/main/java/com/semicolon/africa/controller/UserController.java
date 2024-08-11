package com.semicolon.africa.controller;

import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.*;
import com.semicolon.africa.services.interfaces.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    private final UserServices userServices;


    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("registerUser")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        try {
            RegisterUserResponse response = userServices.registerUser(registerUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), CREATED);
        }
        catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @PostMapping("login")
    public ResponseEntity<?> logIn(@RequestBody LogInRequest logInRequest) {
        try {
            LogInResponse response = userServices.logIn(logInRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), CREATED);
        }
        catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("logOut/{id}")
    public ResponseEntity<?> logOut(@PathVariable("id") String id) {
        LogOutRequest request = new LogOutRequest();
        request.setId(id);
        try {
            LogOutResponse response = userServices.logOut(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @PostMapping("addContact")
    public ResponseEntity<?> addContact(@RequestBody AddPasswordRequest addPasswordRequest){
        try {
            AddPasswordResponse addPasswordResponse = userServices.addPassword(addPasswordRequest);
            return new ResponseEntity<>(new ApiResponse(true, addPasswordResponse), CREATED);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findPasswordByEmail")
        public ResponseEntity<?> findPasswordByEmail(@RequestBody FindPasswordRequest findPasswordRequest) {
        try {
            List<FindPasswordResponse> findPasswordResponses = userServices.findPasswordByEmail(findPasswordRequest);
            return new ResponseEntity<>(new ApiResponse(true, findPasswordResponses), FOUND);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findPasswordByUserName")
        public ResponseEntity<?> findPasswordByUsername(@RequestBody FindPasswordRequest findPasswordRequest) {
        try {
            List<FindPasswordResponse> findPasswordResponses = userServices.findPasswordByUsername(findPasswordRequest);
            return new ResponseEntity<>(new ApiResponse(true, findPasswordResponses), FOUND);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findPasswordByWebLink")
        public ResponseEntity<?> findPasswordByWebLink(@RequestBody FindPasswordRequest findPasswordRequest) {
            try {
                List<FindPasswordResponse> findPasswordResponses = userServices.findPassWordByWebLink(findPasswordRequest);
                return new ResponseEntity<>(new ApiResponse(true, findPasswordResponses), FOUND);
            }catch (Exception message){
                return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findPasswordById")
        public ResponseEntity<?> findPasswordById(@RequestBody FindPasswordRequest findPasswordRequest) {
        try {
            FindPasswordResponse findPasswordResponses = userServices.findPasswordById(findPasswordRequest);
            return new ResponseEntity<>(new ApiResponse(true, findPasswordResponses), FOUND);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @DeleteMapping("deletePasswordById")
    public ResponseEntity<?> deletePasswordById(@RequestBody DeletePasswordRequest deletePasswordRequest) {
        try {
            DeletePasswordResponse response = userServices.deletePasswordById(deletePasswordRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @DeleteMapping("deletePasswordByWebLink")
    public ResponseEntity<?> deletePasswordByWebLink(@RequestBody DeletePasswordRequest deletePasswordRequest) {
        try {
            DeletePasswordResponse response = userServices.deletePasswordByWebLink(deletePasswordRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }
    @GetMapping
    public ResponseEntity<?> generatePassword() {
        try {
           String response = userServices.generatePassword();
           return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @PostMapping("addNote")
    public ResponseEntity<?> addNote(@RequestBody AddNoteRequest addNoteRequest){
        try {
            AddNoteResponse addNoteResponse = userServices.createNote(addNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true, addNoteResponse), CREATED);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @PatchMapping("/updateNote")
    public ResponseEntity<?> updateNote(@RequestBody UpdateNoteRequest updateNoteRequest){
        try {
            UpdateNoteResponse updateNoteResponse = userServices.updateNote(updateNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true, updateNoteResponse), OK);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findNoteById")
    public ResponseEntity<?> findNoteById(@RequestBody FindNoteRequest findNoteRequest) {
        try {
            FindNoteResponse findNoteResponse = userServices.findNoteById(findNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true, findNoteResponse), FOUND);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findNoteByTitle")
    public ResponseEntity<?> findNoteByTitle(@RequestBody FindNoteRequest findNoteRequest) {
        try {
            FindNoteResponse findNoteResponse = userServices.findNoteByTitle(findNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true, findNoteResponse), FOUND);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteNoteByTitle")
    public ResponseEntity<?> deleteNoteByTitle(@RequestBody DeleteNoteRequest deleteNoteRequest) {
        try {
            DeleteNoteResponse response = userServices.deleteNoteByTitle(deleteNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteNoteById")
    public ResponseEntity<?> deleteNoteById(@RequestBody DeleteNoteRequest deleteNoteRequest) {
        try {
            DeleteNoteResponse response = userServices.deleteNoteById(deleteNoteRequest);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false, message.getMessage()),BAD_REQUEST);
        }
    }
}
