package com.pattern.builder.web;

import com.pattern.builder.domain.User;
import com.pattern.builder.domain.UserService;
import com.pattern.builder.domain.dto.RegisterUserDto;
import com.pattern.builder.domain.dto.BasicUserDto;
import com.pattern.builder.domain.dto.PremiumUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final UserService userService;

    @Autowired
    public ApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/basic")
    @ResponseStatus(HttpStatus.CREATED)
    public BasicUserDto saveWithoutCode(@RequestBody RegisterUserDto user) {
        var basicUser = userService.saveBasicUser(user.toUser());

        return BasicUserDto.fromUser(basicUser);
    }

    @PostMapping("/user/premium")
    @ResponseStatus(HttpStatus.CREATED)
    public PremiumUserDto saveWithCode(@RequestBody RegisterUserDto user) {
        var premiumUser = userService.savePremiumUser(user.toUser());

        return PremiumUserDto.fromUser(premiumUser);
    }

    @GetMapping("/user/basic")
    public List<BasicUserDto> listBasicUsers() {
        List<User> basicUserList = userService.listBasicUsers();

        return basicUserList.stream()
                .map(BasicUserDto::fromUser)
                .toList();
    }

    @GetMapping("/user/premium")
    public List<PremiumUserDto> listPremiumUsers() {
        List<User> premiumUserList = userService.listPremiumUsers();

        return premiumUserList.stream()
                .map(PremiumUserDto::fromUser)
                .toList();
    }
}
