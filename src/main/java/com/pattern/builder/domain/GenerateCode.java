package com.pattern.builder.domain;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class GenerateCode {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 10;
    private final SecureRandom random = new SecureRandom();

    public String randomCode() {
        var code = new StringBuilder(CODE_LENGTH);

        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return code.toString();
    }
}