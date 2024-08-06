package com.semicolon.africa.controller;

import com.semicolon.africa.dtos.request.AddPasswordRequest;
import com.semicolon.africa.dtos.request.DeletePasswordRequest;
import com.semicolon.africa.dtos.request.FindPasswordRequest;
import com.semicolon.africa.dtos.response.AddPasswordResponse;
import com.semicolon.africa.dtos.response.ApiResponse;
import com.semicolon.africa.dtos.response.DeletePasswordResponse;
import com.semicolon.africa.dtos.response.FindPasswordResponse;
import com.semicolon.africa.services.interfaces.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/")
public class PasswordController {
    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("create")
    ResponseEntity<?> createPassword(@RequestBody AddPasswordRequest request) {
        try{
            AddPasswordResponse response = passwordService.createPassword(request);
            return new ResponseEntity<>(new ApiResponse(true,response),CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception.getMessage()),BAD_REQUEST);
        }
    }

    @GetMapping("findPasswordByEmail/{email}")
    ResponseEntity<?> findPasswordByEmail(@PathVariable("email") String email){
        FindPasswordRequest request = new FindPasswordRequest();
        request.setEmail(email);
        try {
            List<FindPasswordResponse> responses = passwordService.findPasswordByEmail(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception),BAD_REQUEST);
        }
    }

    @GetMapping("findPasswordById/{id}")
    ResponseEntity<?> findById(@PathVariable("id") String id){
        FindPasswordRequest request = new FindPasswordRequest();
        request.setId(id);
        try {
            FindPasswordResponse response = passwordService.findPasswordById(request);
            return new ResponseEntity<>(new ApiResponse(true,response),FOUND);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception),BAD_REQUEST);
        }
    }

    @GetMapping("findPasswordByUserName/{userName}")
    ResponseEntity<?> findPasswordByUserName(@PathVariable("userName") String userName){
        FindPasswordRequest request = new FindPasswordRequest();
        request.setUserName(userName);
        try{
            List<FindPasswordResponse> response = passwordService.findPasswordByUsername(request);
            return new ResponseEntity<>(new ApiResponse(true,response),FOUND);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception),BAD_REQUEST);
        }
    }

    @GetMapping("findPasswordByWebLink/{webLink}")
    ResponseEntity<?> findPasswordByWebLink(@PathVariable("webLink") String webLink){
        FindPasswordRequest request = new FindPasswordRequest();
        request.setWebsiteLink(webLink);
        try {
            List<FindPasswordResponse> responses = passwordService.findPassWordByWebLink(request);
            return new ResponseEntity<>(new ApiResponse(true,responses),FOUND);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception),BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteByWebLink/{webLink}")
    ResponseEntity<?> deletePasswordByWebLink(@PathVariable("webLink") String webLink) {
        DeletePasswordRequest request = new DeletePasswordRequest();
        request.setId(webLink);
        try {
            DeletePasswordResponse response = passwordService.deletePasswordByWebLink(request);
            return new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(true,exception),BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{id}")
    ResponseEntity<?> deletePasswordById(@PathVariable("id") String id) {
        DeletePasswordRequest request = new DeletePasswordRequest();
        request.setId(id);
        try {
            DeletePasswordResponse response = passwordService.deletePasswordById(request);
            return new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(true,exception),BAD_REQUEST);
        }
    }

    @GetMapping
    ResponseEntity<?> generatePassword(){
        try {
            String generatedPassword = passwordService.generatePassword();
            return new ResponseEntity<>(new ApiResponse(true,generatedPassword),OK);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception),BAD_REQUEST);
        }
    }
}