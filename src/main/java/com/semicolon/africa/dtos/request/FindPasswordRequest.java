package com.semicolon.africa.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FindPasswordRequest {
    private String id;
    private String email;
    private String userName;
    private String websiteLink;
    private String password;
}
