package com.pattern.builder.domain.dto;

import com.pattern.builder.domain.User;

public record BasicUserDto(
        Long id,
        String name,
        String email
) {
    public static BasicUserDto fromUser(User user) {
        return new BasicUserDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
