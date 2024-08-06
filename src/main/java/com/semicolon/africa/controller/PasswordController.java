package com.semicolon.africa.controller;

import com.semicolon.africa.dtos.request.AddPasswordRequest;
import com.semicolon.africa.dtos.response.AddPasswordResponse;
import com.semicolon.africa.dtos.response.ApiResponse;
import com.semicolon.africa.services.interfaces.PasswordService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

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
}