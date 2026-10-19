package com.danilotavares.libraryhubapi.service;

import com.danilotavares.libraryhubapi.dto.UserDTO;
import com.danilotavares.libraryhubapi.entity.User;
import com.danilotavares.libraryhubapi.entity.UserRole;
import com.danilotavares.libraryhubapi.exception.EmailAlreadyExistsException;
import com.danilotavares.libraryhubapi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserDTO requestDTO) {
         Optional<User> existingUser = userRepository.findByEmail(requestDTO.email());

         if (existingUser.isPresent()) {
             throw new EmailAlreadyExistsException("Email já cadastrado.");
         }
         User user = new User();
         user.setName(requestDTO.name());
         user.setEmail(requestDTO.email());
         user.setRole(UserRole.USER);
         user.setCreatedAt(LocalDateTime.now());
         user.setPassword(passwordEncoder.encode(requestDTO.password()));

         userRepository.save(user);
    }
}
