package com.example.urlshortener.utils;

import java.security.SecureRandom;

public class Utils {

    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generateRandomString(int length){
        String chars = "abcdefghijklmnopqrstuvwxyz_";

        StringBuilder string = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomPosition = secureRandom.nextInt(chars.length());
            string.append(chars.charAt(randomPosition));
        }
        return string.toString();
    }
}
