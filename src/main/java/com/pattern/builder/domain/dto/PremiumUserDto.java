package com.pattern.builder.domain.dto;

import com.pattern.builder.domain.User;

public record PremiumUserDto(
        Long id,
        String name,
        String email,
        String code
) {
    public static PremiumUserDto fromUser(User user) {
        return new PremiumUserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCode()
        );
    }
}
