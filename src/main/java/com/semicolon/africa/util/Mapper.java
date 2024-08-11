package com.semicolon.africa.util;

import com.semicolon.africa.data.models.Address;
import com.semicolon.africa.data.models.Note;
import com.semicolon.africa.data.models.Password;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.dtos.request.AddAddressRequest;
import com.semicolon.africa.dtos.request.AddNoteRequest;
import com.semicolon.africa.dtos.request.AddPasswordRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.response.*;

import static com.semicolon.africa.util.PasswordUtil.decryptPassword;
import static com.semicolon.africa.util.PasswordUtil.encryptPassword;


public class Mapper {
    public static void map(Password password, AddPasswordRequest request) {
        password.setUserName(request.getUserName());
        password.setPassword(encryptPassword(request.getPassword()));
        password.setWebsiteLink(request.getWebsiteLink());
        password.setEmail(request.getEmail());
    }

    public static void map(Password password, AddPasswordResponse response) {
        response.setId(password.getId());
        response.setPassword(decryptPassword(password.getPassword()));
        response.setEmail(password.getEmail());
        response.setWebsiteLink(password.getWebsiteLink());
        response.setUserName(password.getUserName());
        response.setMessage("Saved Password");
    }


    public static void map(FindPasswordResponse response, Password password) {
        password.setPassword(decryptPassword(response.getPassword()));
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
        address.setCity(request.getCityOrTown());
        address.setState(request.getState());
        address.setCountry(request.getCountry());
        address.setPhone(request.getPhone());
        address.setEmail(request.getEmail());
        address.setZipPostalCode(request.getZipPostalCode());
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
        addAddressResponse.setCityOrTown(address.getCity());
        addAddressResponse.setState(address.getState());
        addAddressResponse.setCountry(address.getCountry());
        addAddressResponse.setPhone(address.getPhone());
        addAddressResponse.setZipPostalCode(address.getZipPostalCode());
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
        response.setZipPostalCode(address.getZipPostalCode());
        response.setCompany(address.getCompany());
        response.setAddress1(address.getAddress1());
        response.setAddress2(address.getAddress2());
        response.setCityOrTown(address.getCity());
        response.setState(address.getState());
        response.setCountry(address.getCountry());
        response.setPhone(address.getPhone());
        response.setEmail(address.getEmail());
        response.setMessage("Saved Successfully");
    }
    public static void map(RegisterUserRequest request, User user){
        user.setEmail(request.getEmail());
        user.setPassword(encryptPassword(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRegistered(true);
    }
    public static void map(RegisterUserResponse response, User user){
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setPassword(decryptPassword(user.getPassword()));
        response.setPhoneNumber(user.getPhoneNumber());
        response.setMessage("Successfully registered");
    }

    public static void map(AddPasswordResponse response,Password password){
        password.setPassword(decryptPassword(response.getPassword()));
        password.setId(response.getId());
        password.setUserName(response.getUserName());
        password.setEmail(response.getEmail());
        password.setWebsiteLink(response.getWebsiteLink());
    }

    public static void map(Address address,AddAddressResponse response){
        address.setId(response.getId());
        address.setFirstName(response.getFirstName());
        address.setLastName(response.getLastName());
        address.setMiddleName(response.getMiddleName());
        address.setGender(response.getGender());
        address.setBirthday(response.getBirthday());
        address.setCompany(response.getCompany());
        address.setAddress1(response.getAddress1());
        address.setAddress2(response.getAddress2());
        address.setCity(response.getCityOrTown());
        address.setState(response.getState());
        address.setCountry(response.getCountry());
        address.setPhone(response.getPhone());
        address.setZipPostalCode(response.getZipPostalCode());
        address.setEmail(response.getEmail());
    }
}