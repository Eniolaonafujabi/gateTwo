package com.semicolon.africa.util;

import java.util.Random;

public class PasswordUtil {
    public static String encryptPassword(String password) {
        int length = password.length();
        StringBuilder encryptedPassword = new StringBuilder(password);
        encryptedPassword.reverse();
        Random random = new Random();
        encryptedPassword.append("1@11&");
        return encryptedPassword.toString();
    }

    public static String decryptPassword(String encryptedPassword) {
        StringBuilder decryptedPassword = new StringBuilder(encryptedPassword);
        int length = decryptedPassword.length();
        decryptedPassword.delete(length-5,length);
        decryptedPassword.reverse();
        return decryptedPassword.toString();
    }
}
