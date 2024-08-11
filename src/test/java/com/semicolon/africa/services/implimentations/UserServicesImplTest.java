package com.semicolon.africa.services.implimentations;

import com.semicolon.africa.data.repositories.PasswordRepo;
import com.semicolon.africa.data.repositories.Users;
import com.semicolon.africa.dtos.request.AddPasswordRequest;
import com.semicolon.africa.dtos.request.FindPasswordRequest;
import com.semicolon.africa.dtos.request.LogInRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.response.AddPasswordResponse;
import com.semicolon.africa.dtos.response.FindPasswordResponse;
import com.semicolon.africa.dtos.response.LogInResponse;
import com.semicolon.africa.dtos.response.RegisterUserResponse;
import com.semicolon.africa.exception.UserException;
import com.semicolon.africa.services.interfaces.UserServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServicesImplTest {
    @Autowired
    private UserServices userServices;

    @Autowired
    private Users users;
    @Autowired
    private PasswordServiceImpl passwordServiceImpl;

    @Autowired
    private PasswordRepo passwordRepo;

    @BeforeEach
    void setUp() {
        users.deleteAll();
        passwordRepo.deleteAll();
    }

    private RegisterUserResponse registerUser() {
       RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setEmail("eniola@gmail.com");
        registerUserRequest.setPassword("password");
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

    private LogInResponse userLogIn(){
        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setEmail("eniola@gmail.com");
        logInRequest.setPassword("password");
        return userServices.logIn(logInRequest);
    }

    @Test
    public void testThatRegisterUserCanLogIn(){
        RegisterUserResponse registerUserResponse = registerUser();
        assertThat(registerUserResponse.getMessage()).contains("Successfully registered");
        LogInResponse response = userLogIn();
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
    public void testThatUserCan_tLoginWithWrongEmail(){
        registerUser();
        LogInRequest logInRequest = new LogInRequest();
        logInRequest.setEmail("eniola11@gmail.com");
        logInRequest.setPassword("password");
        assertThrows(UserException.class, ()-> userServices.logIn(logInRequest));
    }

    private AddPasswordResponse savePassword(String id) {
        AddPasswordRequest request = new AddPasswordRequest();
        request.setUserId(id);
        request.setUserName("sonOfTheBlackMan");
        request.setWebsiteLink("app.com");
        request.setPassword("password");
        request.setEmail("eniola@gmail.com");
        return userServices.addPassword(request);
    }
    @Test
    public void testThatUserCanSavePassword(){
        RegisterUserResponse registerUserResponse = registerUser();
        userLogIn();
        AddPasswordResponse response = savePassword(registerUserResponse.getId());
        assertThat(response.getMessage()).contains("Saved Password");
    }

    @Test
    public void testThatUserCanFindPasswordByEmail(){
        RegisterUserResponse response1 = registerUser();
        userLogIn();
        AddPasswordResponse response = savePassword(response1.getId());
        FindPasswordRequest request = new FindPasswordRequest();
        request.setEmail(response.getEmail());
        List<FindPasswordResponse> findPasswordResponse = passwordServiceImpl.findPasswordByEmail(request);
        assertThat(findPasswordResponse.size()).isEqualTo(1);
    }

//    @Test

}