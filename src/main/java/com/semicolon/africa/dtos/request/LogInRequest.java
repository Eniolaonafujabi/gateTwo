package com.semicolon.africa.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogInRequest {
    private String email;
    private String password;
}
