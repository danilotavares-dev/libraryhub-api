package com.danilotavares.libraryhubapi.repository;

import com.danilotavares.libraryhubapi.entity.Author;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Set;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}


