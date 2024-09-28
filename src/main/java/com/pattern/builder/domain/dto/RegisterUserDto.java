package com.pattern.builder.domain.dto;

import com.pattern.builder.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterUserDto(
        @NotEmpty(message = "The full name is required.")
        @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
        String name,

        @NotEmpty(message = "The email is required.")
        @Email(message = "The email is invalid.", flags = { Pattern.Flag.CASE_INSENSITIVE })
        String email
) {
    public User toUser() {
        return User.builder()
                .name(name)
                .email(email)
                .build();
    }
}
