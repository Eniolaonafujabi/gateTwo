package com.semicolon.africa.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Document
public class User {
    private String id;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean isRegistered;
    private boolean state;
    @DBRef
    private List<Address> addresses = new ArrayList<>();
    @DBRef
    private List<Note> notes = new ArrayList<>();
    @DBRef
    private List<Password> passwords = new ArrayList<>();
}
