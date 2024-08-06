package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.models.Password;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PasswordRepoTest {
    @Autowired
    private PasswordRepo passwordRepo;
    @BeforeEach
    void setUp() {
        passwordRepo.deleteAll();
    }

    private void createPassword() {
        Password password = new Password();
        password.setEmail("eniola@gmail.com");
        password.setPassword("123456");
        password.setWebsiteLink("app.com");
        password.setUserName("guapDaddy");
        passwordRepo.save(password);
    }

    @Test
    public void testPasswordRepoCanSave() {
        createPassword();
        assertEquals(passwordRepo.count(),1);
    }
    @Test
    public void testPasswordRepoCanFindByEmail() {
        createPassword();
        assertNotNull(passwordRepo.findByEmail("eniola@gmail.com"));
    }
    @Test
    public void testPasswordRepoCanFindByUserName() {
        createPassword();
        assertNotNull(passwordRepo.findByUserName("guapDaddy"));
    }
    @Test
    public void testPasswordRepoCanFindByWebsiteLink() {
        createPassword();
        assertNotNull(passwordRepo.findByWebsiteLink("app.com"));
    }
}