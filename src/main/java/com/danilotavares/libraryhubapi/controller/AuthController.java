package com.danilotavares.libraryhubapi.controller;

import com.danilotavares.libraryhubapi.dto.RegisterRequestDTO;
import com.danilotavares.libraryhubapi.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegisterRequestDTO requestDTO) {
        authService.register(requestDTO);
    }
}
