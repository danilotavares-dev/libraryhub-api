package com.danilotavares.libraryhubapi.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthorDTO (
    @NotBlank(message = "O nome do autor é obrigatório.")
    String name,

    String biography
) {}
