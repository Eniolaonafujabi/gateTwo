package com.semicolon.africa.util;

import com.semicolon.africa.data.models.Address;
import com.semicolon.africa.data.models.Note;
import com.semicolon.africa.data.models.Password;
import com.semicolon.africa.dtos.request.AddAddressRequest;
import com.semicolon.africa.dtos.request.AddNoteRequest;
import com.semicolon.africa.dtos.request.AddPasswordRequest;
import com.semicolon.africa.dtos.response.*;

public class Mapper {
    public static void map(Password password, AddPasswordRequest request) {
        password.setUserName(request.getUserName());
        password.setPassword(request.getPassword());
        password.setWebsiteLink(request.getWebsiteLink());
        password.setEmail(request.getEmail());
    }

    public static void map(Password password, AddPasswordResponse response) {
        response.setId(password.getId());
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
        password.setId(response.getId());
    }
    public static void map(AddNoteRequest request, Note note) {
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
    }
    public static void map(AddNoteResponse response, Note note) {
        response.setId(note.getId());
        response.setTitle(note.getTitle());
        response.setContent(note.getContent());
        response.setMessage("Successfully created note");
    }
    public static void map(UpdateNoteResponse response, Note note){
        response.setId(note.getId());
        response.setTitle(note.getTitle());
        response.setContent(note.getContent());
        response.setMessage("Note Updated");
    }
    public static void map(FindNoteResponse response, Note note){
        response.setId(note.getId());
        response.setTitle(note.getTitle());
        response.setContent(note.getContent());
        response.setMessage("Found");
    }
    public static void map(AddAddressRequest request, Address address){
        address.setFirstName(request.getFirstName());
        address.setLastName(request.getLastName());
        address.setMiddleName(request.getMiddleName());
        address.setGender(request.getGender());
        address.setBirthday(request.getBirthday());
        address.setCompany(request.getCompany());
        address.setAddress1(request.getAddress1());
        address.setAddress2(request.getAddress2());
        address.setCityOrTown(request.getCityOrTown());
        address.setState(request.getState());
        address.setCountry(request.getCountry());
        address.setPhone(request.getPhone());
        address.setEmail(request.getEmail());
    }
    public static void map(AddAddressResponse addAddressResponse,Address address){
        addAddressResponse.setId(address.getId());
        addAddressResponse.setFirstName(address.getFirstName());
        addAddressResponse.setLastName(address.getLastName());
        addAddressResponse.setMiddleName(address.getMiddleName());
        addAddressResponse.setGender(address.getGender());
        addAddressResponse.setBirthday(address.getBirthday());
        addAddressResponse.setCompany(address.getCompany());
        addAddressResponse.setAddress1(address.getAddress1());
        addAddressResponse.setAddress2(address.getAddress2());
        addAddressResponse.setCityOrTown(address.getCityOrTown());
        addAddressResponse.setState(address.getState());
        addAddressResponse.setCountry(address.getCountry());
        addAddressResponse.setPhone(address.getPhone());
        addAddressResponse.setEmail(address.getEmail());
        addAddressResponse.setMessage("Saved Successfully");
    }
    public static void map(FindAddressResponse response, Address address){
        response.setId(address.getId());
        response.setFirstName(address.getFirstName());
        response.setLastName(address.getLastName());
        response.setMiddleName(address.getMiddleName());
        response.setGender(address.getGender());
        response.setBirthday(address.getBirthday());
        response.setCompany(address.getCompany());
        response.setAddress1(address.getAddress1());
        response.setAddress2(address.getAddress2());
        response.setCityOrTown(address.getCityOrTown());
        response.setState(address.getState());
        response.setCountry(address.getCountry());
        response.setPhone(address.getPhone());
        response.setEmail(address.getEmail());
        response.setMessage("Saved Successfully");
    }
}