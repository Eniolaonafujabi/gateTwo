package com.semicolon.africa.util;

import com.semicolon.africa.data.models.Password;
import com.semicolon.africa.dtos.request.AddPasswordRequest;
import com.semicolon.africa.dtos.response.AddPasswordResponse;
import com.semicolon.africa.dtos.response.FindPasswordResponse;

public class Mapper {
    public static void map(Password password, AddPasswordRequest request) {
        password.setUserName(request.getUserName());
        password.setPassword(request.getPassword());
        password.setWebsiteLink(request.getWebsiteLink());
        password.setEmail(request.getEmail());
    }

    public static void map(Password password, AddPasswordResponse response) {
        response.setId(password.getPasswordId());
        response.setPassword(password.getPassword());
        response.setEmail(password.getEmail());
        response.setWebsiteLink(password.getWebsiteLink());
        response.setUserName(password.getUserName());
        response.setMessage("Saved Password");
    }

    public static void map(FindPasswordResponse response, Password password) {
        password.setPassword(response.getPassword());
        password.setEmail(response.getEmail());
        password.setWebsiteLink(response.getWebsiteLink());
        password.setUserName(response.getUserName());
        password.setPasswordId(response.getId());
    }
}