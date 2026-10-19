package com.danilotavares.libraryhubapi.controller;

import com.danilotavares.libraryhubapi.dto.BookDTO;
import com.danilotavares.libraryhubapi.entity.Book;
import com.danilotavares.libraryhubapi.repository.BookRepository;
import com.danilotavares.libraryhubapi.service.BookService;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    public BookService bookService;
    public BookRepository bookRepository;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/register")
    @PermitAll
    public void register(@Valid @RequestBody BookDTO requestDTO) {
        bookService.register(requestDTO);
    }

    @GetMapping("/search")
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
