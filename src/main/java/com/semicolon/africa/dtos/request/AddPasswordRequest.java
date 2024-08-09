package com.semicolon.africa.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddPasswordRequest {
    private String userId;
    private String email;
    private String userName;
    private String websiteLink;
    private String password;
}
