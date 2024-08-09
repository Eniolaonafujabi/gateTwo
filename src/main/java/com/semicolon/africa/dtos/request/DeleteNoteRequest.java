package com.semicolon.africa.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeleteNoteRequest {
    private String userId;
    private String Id;
    private String title;
}
