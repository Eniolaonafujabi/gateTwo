package com.semicolon.africa.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateNoteResponce {
    private int id;
    private String title;
    private String content;
    private String message;
}
