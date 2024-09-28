package com.pattern.builder.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final GenerateCode generateCode;

    @Autowired
    public UserService(UserRepository userRepository, GenerateCode generateCode) {
        this.userRepository = userRepository;
        this.generateCode = generateCode;
    }

    public User savePremiumUser(User user) {
        var newUser = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .code(generateCode.randomCode())
                .type(UserType.PREMIUM)
                .build();

        return userRepository.save(newUser);
    }

    public User saveBasicUser(User user) {
        var newUser = User.builder()
                .name(user.getName())
                .email(user.getEmail())
                .type(UserType.BASIC)
                .build();

        return userRepository.save(newUser);
    }

    public List<User> listBasicUsers() {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getType() == UserType.BASIC)
                .collect(Collectors.toList());
    }

    public List<User> listPremiumUsers() {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getType() == UserType.PREMIUM)
                .collect(Collectors.toList());
    }
}
