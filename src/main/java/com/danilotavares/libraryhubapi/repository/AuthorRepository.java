package com.danilotavares.libraryhubapi.repository;

import com.danilotavares.libraryhubapi.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
