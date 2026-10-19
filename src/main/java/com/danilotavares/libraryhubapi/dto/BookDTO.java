package com.danilotavares.libraryhubapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.Set;

public record BookDTO (
        @NotBlank(message = "O título é obrigatório.")
        String title,

        @NotBlank(message = "O ISBN do livro é obrigatório.")
        String isbn,

        @NotNull
        @PositiveOrZero
        Integer publicationYear,

        @NotNull
        @PositiveOrZero
        int quantity,

        @NotNull
        @PositiveOrZero
        int availableQuantity,

        @NotNull
        Set<Long> authors
) {}
