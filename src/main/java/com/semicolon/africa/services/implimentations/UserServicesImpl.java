package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.models.Address;
import com.semicolon.africa.data.models.Password;
import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.Users;
import com.semicolon.africa.dtos.request.*;
import com.semicolon.africa.dtos.response.*;
import com.semicolon.africa.exception.UserException;
import com.semicolon.africa.services.interfaces.AddressServices;
import com.semicolon.africa.services.interfaces.NoteServices;
import com.semicolon.africa.services.interfaces.PasswordService;
import com.semicolon.africa.services.interfaces.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.semicolon.africa.util.Mapper.map;
import static com.semicolon.africa.util.PasswordUtil.decryptPassword;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private Users users;

    @Autowired
    private  NoteServices noteServices;

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private AddressServices addressServices;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        User user = new User();
        emailExits(request.getEmail());
        phoneNumberExits(request.getPhoneNumber());
        map(request,user);
        users.save(user);
        RegisterUserResponse response = new RegisterUserResponse();
        map(response,user);
        return response;
    }

    private void phoneNumberExits(String phoneNumber) {
        boolean check = users.existsByPhoneNumber(phoneNumber);
        if (check) {
            throw new UserException("Number already in use");
        }
    }

    private void emailExits(String email) {
        boolean check = users.existsByEmail(email);
        if (check) {
            throw new UserException("Email already in use");
        }
    }

    @Override
    public LogInResponse logIn(LogInRequest request) {
        LogInResponse response = new LogInResponse();
        User user = findUserByEmail(request.getEmail());
        if (decryptPassword(user.getPassword()).equals(request.getPassword())) {
            user.setState(true);
            users.save(user);
            response.setMessage("Successfully logged in");
        }else {
            throw new UserException("Wrong details");
        }
        return response;
    }

    private User findUserByEmail(String email) {
        return users.findByEmail(email)
                .orElseThrow(() -> new UserException("Wrong details"));
    }

    @Override
    public LogOutResponse logOut(LogOutRequest request) {
        User user = findUserById(request.getId());
        user.setState(false);
        users.save(user);
        LogOutResponse response = new LogOutResponse();
        response.setMessage("Successfully logged out");
        return response;
    }

    @Override
    public AddPasswordResponse addPassword(AddPasswordRequest request) {
        User user = findUserById(request.getUserId());
        AddPasswordResponse response = new AddPasswordResponse();
        if (user.isState()){
            response = passwordService.createPassword(request);
            Password password = new Password();
            map(response,password);
            List<Password> passwords = user.getPasswords();
            passwords.add(password);
            users.save(user);
            return response;
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindPasswordResponse> findPasswordByEmail(FindPasswordRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return passwordService.findPasswordByEmail(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindPasswordResponse> findPasswordByUsername(FindPasswordRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
           return passwordService.findPasswordByUsername(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindPasswordResponse> findPassWordByWebLink(FindPasswordRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return passwordService.findPassWordByWebLink(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public FindPasswordResponse findPasswordById(FindPasswordRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return passwordService.findPasswordById(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public DeletePasswordResponse deletePasswordById(DeletePasswordRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return passwordService.deletePasswordById(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public DeletePasswordResponse deletePasswordByWebLink(DeletePasswordRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return passwordService.deletePasswordByWebLink(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public String generatePassword() {
        return passwordService.generatePassword();
    }

    @Override
    public AddNoteResponse createNote(AddNoteRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return noteServices.createNote(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public UpdateNoteResponse updateNote(UpdateNoteRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return noteServices.updateNote(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public FindNoteResponse findNoteById(FindNoteRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return noteServices.findById(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public FindNoteResponse findNoteByTitle(FindNoteRequest request) {
        User user = findUserById(request.getUserId());
        if(user.isState()){
            return noteServices.findByTitle(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public DeleteNoteResponse deleteNoteByTitle(DeleteNoteRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return noteServices.deleteNoteByTitle(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public DeleteNoteResponse deleteNoteById(DeleteNoteRequest request) {
        User user = findUserById(request.getUserId());
        if(user.isState()){
            return noteServices.deleteNoteById(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public AddAddressResponse createUserAddress(AddAddressRequest request) {
        User user = findUserById(request.getUserId());
        AddAddressResponse response = new AddAddressResponse();
        if (user.isState()){
            response = addressServices.createAddress(request);
            Address address = new Address();
            map(address,response);
            List<Address> addresses = user.getAddresses();
            addresses.add(address);
        users.save(user);
        return response;
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public FindAddressResponse findAddressById(FindAddressRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
           return addressServices.findById(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindAddressResponse> findAddressByFirstName(FindAddressRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return addressServices.findByFirstName(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindAddressResponse> findAddressByMiddleName(FindAddressRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return addressServices.findByMiddleName(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindAddressResponse> findAddressByLastName(FindAddressRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return addressServices.findByLastName(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindAddressResponse> findAddressByGender(FindAddressRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return addressServices.findByGender(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindAddressResponse> findAddressByCompany(FindAddressRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return addressServices.findByCompany(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindAddressResponse> findByAddress1(FindAddressRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return addressServices.findByAddress1(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindAddressResponse> findAddressByAddress2(FindAddressRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return addressServices.findByAddress2(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindAddressResponse> findAddressByCityOrTown(FindAddressRequest request) {
        return List.of();
    }

    @Override
    public List<FindAddressResponse> findAddressByCountry(FindAddressRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return addressServices.findByCountry(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindAddressResponse> findAddressByState(FindAddressRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return addressServices.findByState(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindAddressResponse> findAddressByPhoneNumber(FindAddressRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return addressServices.findByPhoneNumber(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public List<FindAddressResponse> findAddressByEmail(FindAddressRequest request) {
        User user = findUserById(request.getUserId());
        if (user.isState()){
            return addressServices.findByEmail(request);
        }
        throw new UserException("You are not logged in");
    }

    @Override
    public DeleteAddressResponse deleteAddress(DeleteAddressRequest addressRequest) {
        User user = findUserById(addressRequest.getUserId());
        if (user.isState()){
            return addressServices.delete(addressRequest);
        }
        throw new UserException("You are not logged in");
    }

    private User findUserById(String id) {
        return users.findById(id)
                .orElseThrow(() -> new UserException("User not found"));
    }
}
