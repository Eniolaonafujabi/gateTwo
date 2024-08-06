package com.semicolon.africa.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeletePasswordRequest {
    private String id;
    private String webLink;
}
