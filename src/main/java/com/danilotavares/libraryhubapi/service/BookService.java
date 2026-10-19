package com.danilotavares.libraryhubapi.service;

import com.danilotavares.libraryhubapi.dto.BookDTO;
import com.danilotavares.libraryhubapi.entity.Author;
import com.danilotavares.libraryhubapi.entity.Book;
import com.danilotavares.libraryhubapi.exception.EntityNotFoundException;
import com.danilotavares.libraryhubapi.exception.IsbnAlreadyExistsException;
import com.danilotavares.libraryhubapi.exception.QuantityInvalidException;
import com.danilotavares.libraryhubapi.repository.AuthorRepository;
import com.danilotavares.libraryhubapi.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public void register(BookDTO bookDTO) {
        Optional<Book> existingIsbn = bookRepository.findByIsbn(bookDTO.isbn());

        if (existingIsbn.isPresent()) {
            throw new IsbnAlreadyExistsException("O ISBN já registrado");
        }

        Set<Author> authors = new HashSet<>(
                authorRepository.findAllById(bookDTO.authors())
        );

        if (authors.size() != bookDTO.authors().size()) {
            throw new EntityNotFoundException("Um ou mais autores não foram encontrados.");
        }

        if (
                bookDTO.availableQuantity() > bookDTO.quantity() ||
                bookDTO.quantity() < 0 ||
                bookDTO.availableQuantity() < 0)
        {
            throw new QuantityInvalidException("Quantidade inválida.");
        }

        Book book = new Book();

        book.setTitle(bookDTO.title());
        book.setIsbn(bookDTO.isbn());
        book.setPublicationYear(bookDTO.publicationYear());
        book.setQuantity(bookDTO.quantity());
        book.setAvailableQuantity(bookDTO.availableQuantity());
        book.setAuthors(authors);
        book.setCreatedAt(LocalDateTime.now());
        bookRepository.save(book);
    }
}
