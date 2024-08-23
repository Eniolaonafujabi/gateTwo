package com.semicolon.africa.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserResponse {
    private String id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private String message;
}
