package com.semicolon.africa.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Setter
@Getter
public class DeleteNoteRequest {
    private String userId;
    private String Id;
    private String title;
}
