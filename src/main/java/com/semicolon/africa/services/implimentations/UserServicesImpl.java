package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.models.User;
import com.semicolon.africa.data.repositories.Users;
import com.semicolon.africa.dtos.request.LogInRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.response.LogInResponse;
import com.semicolon.africa.dtos.response.RegisterUserResponse;
import com.semicolon.africa.exception.UserException;
import com.semicolon.africa.services.interfaces.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.semicolon.africa.util.Mapper.map;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private Users users;

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
        if (user.getPassword().equals(request.getPassword())) {
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
    public RegisterUserResponse logOut(RegisterUserRequest request) {
        return null;
    }
}
