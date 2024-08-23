package com.semicolon.africa.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequest {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
}
