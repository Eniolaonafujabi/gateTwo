package com.semicolon.africa.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Setter
@Getter
public class AddNoteRequest{
    private String userId;
    private String title;
    private String content;
}
