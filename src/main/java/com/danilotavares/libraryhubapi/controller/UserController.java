package com.danilotavares.libraryhubapi.controller;

import com.danilotavares.libraryhubapi.dto.UserDTO;
import com.danilotavares.libraryhubapi.entity.User;
import com.danilotavares.libraryhubapi.repository.UserRepository;
import com.danilotavares.libraryhubapi.service.UserService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    @PermitAll
    public void register(@Valid @RequestBody UserDTO requestDTO) {
        userService.register(requestDTO);
    }

    @GetMapping("/search")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
