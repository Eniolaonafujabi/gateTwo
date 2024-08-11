package com.semicolon.africa.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordUtilTest {

    @Test
    public void testEncryptPassword() {
        String encryptedPassword = PasswordUtil.encryptPassword("password");
        assertEquals("drowssap111", encryptedPassword);
    }

        @Test
    public void testDecryptPassword() {
        String encryptedPassword = PasswordUtil.encryptPassword("password");
        String decryptedPassword = PasswordUtil.decryptPassword(encryptedPassword);
        assertEquals("password", decryptedPassword);
    }
}