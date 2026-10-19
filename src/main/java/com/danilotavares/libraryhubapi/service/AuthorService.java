package com.danilotavares.libraryhubapi.service;

import com.danilotavares.libraryhubapi.dto.AuthorDTO;
import com.danilotavares.libraryhubapi.entity.Author;
import com.danilotavares.libraryhubapi.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void register(AuthorDTO authorDTO) {
        Author author = new Author();

        author.setName(authorDTO.name());
        author.setBiography(authorDTO.biography());
        authorRepository.save(author);
    }
}
