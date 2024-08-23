package com.semicolon.africa.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Setter
@Getter
public class DeletePasswordRequest {
    private String userId;
    private String id;
    private String webLink;
}
