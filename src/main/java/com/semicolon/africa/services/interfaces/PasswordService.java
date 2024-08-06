package com.semicolon.africa.services.interfaces;

import com.semicolon.africa.dtos.request.DeletePasswordRequest;
import com.semicolon.africa.dtos.request.FindPasswordRequest;
import com.semicolon.africa.dtos.response.DeletePasswordResponse;
import com.semicolon.africa.dtos.response.FindPasswordResponse;
import com.semicolon.africa.dtos.request.AddPasswordRequest;
import com.semicolon.africa.dtos.response.AddPasswordResponse;

import java.util.List;

public interface PasswordService {
    AddPasswordResponse createPassword(AddPasswordRequest request);

    List<FindPasswordResponse> findPasswordByEmail(FindPasswordRequest request);

    List<FindPasswordResponse> findPasswordByUsername(FindPasswordRequest request);

    List<FindPasswordResponse> findPassWordByWebLink(FindPasswordRequest request);

    FindPasswordResponse findPasswordById(FindPasswordRequest request);

    DeletePasswordResponse deletePasswordById(DeletePasswordRequest request);

    DeletePasswordResponse deletePasswordByWebLink(DeletePasswordRequest request);

    String generatePassword();

}
