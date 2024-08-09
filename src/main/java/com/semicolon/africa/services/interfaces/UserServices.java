package com.semicolon.africa.services.interfaces;

import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.*;

import java.util.List;

public interface UserServices {
    RegisterUserResponse registerUser(RegisterUserRequest request);

    LogInResponse logIn(LogInRequest request);

    LogOutResponse logOut(LogOutRequest request);

    AddPasswordResponse addPassword(AddPasswordRequest request);

    List<FindPasswordResponse> findPasswordByEmail(FindPasswordRequest request);

    List<FindPasswordResponse> findPasswordByUsername(FindPasswordRequest request);

    List<FindPasswordResponse> findPassWordByWebLink(FindPasswordRequest request);

    FindPasswordResponse findPasswordById(FindPasswordRequest request);

    DeletePasswordResponse deletePasswordById(DeletePasswordRequest request);

    DeletePasswordResponse deletePasswordByWebLink(DeletePasswordRequest request);

    String generatePassword();

    AddNoteResponse createNote(AddNoteRequest request);

    UpdateNoteResponse updateNote(UpdateNoteRequest request);

    FindNoteResponse findNoteById(FindNoteRequest request);

    FindNoteResponse findNoteByTitle(FindNoteRequest request);

    DeleteNoteResponse deleteNoteByTitle(DeleteNoteRequest request);

    DeleteNoteResponse deleteNoteById(DeleteNoteRequest request);

     AddAddressResponse createUserAddress(AddAddressRequest request);

     FindAddressResponse findAddressById(FindAddressRequest request);

     List<FindAddressResponse> findAddressByFirstName(FindAddressRequest request);

     List<FindAddressResponse> findAddressByMiddleName(FindAddressRequest request);

     List<FindAddressResponse> findAddressByLastName(FindAddressRequest request);

     List<FindAddressResponse> findAddressByGender(FindAddressRequest request);

     List<FindAddressResponse> findAddressByCompany(FindAddressRequest request);

     List<FindAddressResponse> findByAddress1(FindAddressRequest request);

     List<FindAddressResponse> findAddressByAddress2(FindAddressRequest request);

     List<FindAddressResponse> findAddressByCityOrTown(FindAddressRequest request);

    List<FindAddressResponse> findAddressByCountry(FindAddressRequest request);

    List<FindAddressResponse> findAddressByState(FindAddressRequest request);

    List<FindAddressResponse> findAddressByPhoneNumber(FindAddressRequest request);

    List<FindAddressResponse> findAddressByEmail(FindAddressRequest request);

    DeleteAddressResponse deleteAddress(DeleteAddressRequest addressRequest);
}