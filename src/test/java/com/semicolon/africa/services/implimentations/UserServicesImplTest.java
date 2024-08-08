package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.repositories.Users;
import com.semicolon.africa.dtos.request.LogInRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.response.LogInResponse;
import com.semicolon.africa.dtos.response.RegisterUserResponse;
import com.semicolon.africa.exception.UserException;
import com.semicolon.africa.services.interfaces.UserServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServicesImplTest {
    @Autowired
    private UserServices userServices;

    @Autowired
    private Users users;

    @BeforeEach
    void setUp() {
        users.deleteAll();
    }

    private RegisterUserResponse registerUser() {
       RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("eniola@Gmail.com");
        registerUserRequest.setPassword("password");
        registerUserRequest.setPassword("1234");
        return userServices.registerUser(registerUserRequest);
    }

    @Test
    public void testThatYouCanRegisterUser() {
        RegisterUserResponse registerUserResponse = registerUser();
        assertThat(registerUserResponse.getMessage()).contains("Successfully registered");
    }

    @Test
    public void testThatUserCan_tRegisterWithExitingEmail() {
        RegisterUserResponse registerUserResponse = registerUser();
        assertThrows(UserException.class, this::registerUser);
        //method reference
    }

    @Test
    public void testThatUserCan_tRegisterWithExitingPhoneNumber() {
        RegisterUserResponse registerUserResponse = registerUser();
        assertThrows(UserException.class, this::registerUser);
    }

    @Test
    public void testThatRegisterUserCanLogIn(){
        RegisterUserResponse registerUserResponse = registerUser();
        assertThat(registerUserResponse.getMessage()).contains("Successfully registered");
        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setEmail("eniola@gmail.com");
        logInRequest.setPassword("password");
        LogInResponse response = userServices.logIn(logInRequest);
        assertThat(response.getMessage()).contains("Successfully logged in");
    }

    @Test
    public void testThatUserCan_LoginWithWrongPassword(){
        registerUser();
        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setEmail("eniola@gmail.com");
        logInRequest.setPassword("password1");
        assertThrows(UserException.class, ()-> userServices.logIn(logInRequest));
    }

    @Test
    public void testThatUserCan_LoginWithWrongEmail(){
        registerUser();
        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setEmail("eniola11@gmail.com");
        logInRequest.setPassword("password");
        assertThrows(UserException.class, ()-> userServices.logIn(logInRequest));
    }
}