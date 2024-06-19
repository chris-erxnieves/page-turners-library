package com.pageturnerslibrary.api.controller;

import com.pageturnerslibrary.api.service.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public String login(Authentication authentication) {
        return tokenService.generateToken(authentication);
    }

    // TODO: Add logout functionality
    @PostMapping("/logout")
    public String logout(Authentication authentication) {
        return "";
    }

}
