package com.semicolon.africa.services.interfaces;

import com.semicolon.africa.data.repositories.PasswordRepo;
import com.semicolon.africa.dtos.request.AddPasswordRequest;
import com.semicolon.africa.dtos.request.DeletePasswordRequest;
import com.semicolon.africa.dtos.request.FindPasswordRequest;
import com.semicolon.africa.dtos.response.AddPasswordResponse;
import com.semicolon.africa.dtos.response.DeletePasswordResponse;
import com.semicolon.africa.dtos.response.FindPasswordResponse;
import com.semicolon.africa.services.implimentations.PasswordServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PasswordServiceImplTest {
    @Autowired
    private PasswordRepo passwordRepo;

    @Autowired
    private PasswordServiceImpl passwordService;

    @BeforeEach
    void setUp() {
        passwordRepo.deleteAll();
    }

    private AddPasswordResponse createPassword(){
        AddPasswordRequest request = new AddPasswordRequest();
        request.setUserName("sonOfTheBlackMan");
        request.setWebsiteLink("app.com");
        request.setPassword("password");
        request.setEmail("eniola@gmail.com");
        AddPasswordResponse response = passwordService.createPassword(request);
        return response;
    }

    @Test
    public void testThatCreatePassword() {
        AddPasswordResponse response = createPassword();
        assertThat(response.getMessage()).contains("Saved Password");
    }

    @Test
    public void testThatFindPasswordWithEmail() {
        AddPasswordResponse response = createPassword();
        createPassword();
        assertThat(response.getMessage()).isNotNull();
        FindPasswordRequest request = new FindPasswordRequest();
        request.setEmail("eniola@gmail.com");
        List<FindPasswordResponse> responses = passwordService.findPasswordByEmail(request);
        assertThat(responses.size()).isEqualTo(2);
    }

        @Test
    public void testThatFindPasswordWithUserName() {
        AddPasswordResponse response = createPassword();
        createPassword();
        assertThat(response.getMessage()).isNotNull();
        FindPasswordRequest request = new FindPasswordRequest();
        request.setUserName("sonOfTheBlackMan");
        List<FindPasswordResponse> responses = passwordService.findPasswordByUsername(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatFindPasswordWithWebLink() {
        AddPasswordResponse response = createPassword();
        createPassword();
        assertThat(response.getMessage()).isNotNull();
        FindPasswordRequest request = new FindPasswordRequest();
        request.setWebsiteLink("app.com");
        List<FindPasswordResponse> responses = passwordService.findPassWordByWebLink(request);
        assertThat(responses.size()).isEqualTo(2);
    }

    @Test
    public void testThatICanDeletePasswordByWebLink(){
        createPassword();
        DeletePasswordRequest request = new DeletePasswordRequest();
        request.setWebLink("app.com");
        DeletePasswordResponse response = passwordService.deletePasswordByWebLink(request);
        assertThat(response.getMessage()).contains("Deleted Password");
    }

    @Test
    public void testThatICanGeneratePassword(){
        AddPasswordRequest request = new AddPasswordRequest();
        request.setUserName("sonOfTheBlackMan");
        request.setWebsiteLink("app.com");
        request.setPassword(passwordService.generatePassword());
        request.setEmail("eniola@gmail.com");
        AddPasswordResponse response = passwordService.createPassword(request);
        assertThat(response.getPassword()).isNotNull();
    }

    @Test
    public void testThatICanFindId(){
        AddPasswordResponse response = createPassword();
        FindPasswordRequest request = new FindPasswordRequest();
        request.setId(response.getId());
        assertThat(passwordService.findPasswordById(request)).isNotNull();
    }

    @Test
    public void testThatICanDeleteById(){
        AddPasswordResponse response = createPassword();
        DeletePasswordRequest request = new DeletePasswordRequest();
        request.setId(response.getId());
        DeletePasswordResponse response1 = passwordService.deletePasswordById(request);
        assertThat(response1.getMessage()).contains("Deleted");
    }
}