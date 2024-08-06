package com.semicolon.africa.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class Password {
    @Id
    private String id;
    private String email;
    private String userName;
    private String websiteLink;
    private String password;
}
