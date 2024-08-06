package com.semicolon.africa.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FindPasswordResponse {
    private String id;
    private String email;
    private String userName;
    private String websiteLink;
    private String password;
}
