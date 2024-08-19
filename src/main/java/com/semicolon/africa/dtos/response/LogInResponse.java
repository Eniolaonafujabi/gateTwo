package com.semicolon.africa.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogInResponse {
    private String userEmail;
    private String userId;
    private String message;
}
