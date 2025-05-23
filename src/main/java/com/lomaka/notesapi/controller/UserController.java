package com.lomaka.notesapi.controller;

import com.lomaka.notesapi.dto.UserDtoLoginRequest;
import com.lomaka.notesapi.dto.UserDtoRequest;
import com.lomaka.notesapi.dto.UserDtoRespond;
import com.lomaka.notesapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody @Valid UserDtoRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UserDtoLoginRequest request) {
        return userService.login(request);
    }

    @GetMapping("/me")
    public UserDtoRespond getCurrentUser() {
        return userService.getCurrentUser();
    }



    @GetMapping("/confirm")
    public Map<String, String> confirmEmail(@RequestParam String token) {
        return userService.confirmUser(token);
    }
}
