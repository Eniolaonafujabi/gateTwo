package com.semicolon.africa.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Setter
@Getter
public class User {
    private String id;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean isRegitered;
    private boolean state;
    @DBRef
    private List<Address> addresses;
    @DBRef
    private List<Note> notes;
    @DBRef
    private List<Password> passwords;
}
