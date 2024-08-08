package com.semicolon.africa.services.interfaces;

import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.*;

import java.util.List;

public interface UserServices {
    RegisterUserResponse registerUser(RegisterUserRequest request);

    LogInResponse logIn(LogInRequest request);

    RegisterUserResponse logOut(RegisterUserRequest request);

//    AddPasswordResponse addPassword(AddPasswordRequest request);
//
//    List<FindPasswordResponse> findPasswordByEmail(FindPasswordRequest request);
//
//    List<FindPasswordResponse> findPasswordByUsername(FindPasswordRequest request);
//
//    List<FindPasswordResponse> findPassWordByWebLink(FindPasswordRequest request);
//
//    FindPasswordResponse findPasswordById(FindPasswordRequest request);
//
//    DeletePasswordResponse deletePasswordById(DeletePasswordRequest request);
//
//    DeletePasswordResponse deletePasswordByWebLink(DeletePasswordRequest request);
//
//    String generatePassword();
}
