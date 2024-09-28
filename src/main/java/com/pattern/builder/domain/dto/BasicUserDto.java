package com.pattern.builder.domain.dto;

import com.pattern.builder.domain.User;
import com.pattern.builder.domain.UserType;

public record BasicUserDto(
        Long id,
        String name,
        String email,
        UserType userType
) {
    public static BasicUserDto fromUser(User user) {
        return new BasicUserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getType()
        );
    }
}
