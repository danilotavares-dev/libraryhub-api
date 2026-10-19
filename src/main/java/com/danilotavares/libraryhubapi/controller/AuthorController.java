package com.danilotavares.libraryhubapi.controller;

import com.danilotavares.libraryhubapi.dto.AuthorDTO;
import com.danilotavares.libraryhubapi.entity.Author;
import com.danilotavares.libraryhubapi.repository.AuthorRepository;
import com.danilotavares.libraryhubapi.service.AuthorService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorService authorService, AuthorRepository authorRepository) {
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }

    @PostMapping("/register")
    @PermitAll
    public void register(@Valid @RequestBody AuthorDTO authorDTO) {
        authorService.register(authorDTO);
    }

    @GetMapping("/search")
    public List<Author> findAllBooks() {
        return authorRepository.findAll();
    }
}
