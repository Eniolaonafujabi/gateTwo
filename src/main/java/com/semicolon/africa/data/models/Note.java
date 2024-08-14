package com.semicolon.africa.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("PhoneNumberManagementNotes")
public class Note {
    private String  id;
    private String  title;
    private String  content;
}
