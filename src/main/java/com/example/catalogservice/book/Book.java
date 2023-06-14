package com.example.catalogservice.book;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public record Book(
        @NotBlank(message = "ISBN Can't be empty")
        @Pattern(
                regexp = "^([\\d]{10}|[\\d]{13})$",
                message = "ISBN must be 10 or 13 characters long"
        )
        String isbn,
        @NotBlank(message = "title can't be empty") String title,
        @NotBlank(message = "author can't be empty") String author,
        @NotNull(message = "Book must have a price")
        @Positive(message = "price can't be negative") Double price) {
}
