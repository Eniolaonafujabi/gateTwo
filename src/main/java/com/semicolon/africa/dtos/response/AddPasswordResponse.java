package com.semicolon.africa.dtos.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class AddPasswordResponse {
    private String id;
    private String message;
    private String email;
    private String userName;
    private String websiteLink;
    private String password;
}
