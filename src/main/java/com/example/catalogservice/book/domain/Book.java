package com.example.catalogservice.book.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.Instant;

public record Book(

        @Id Long id,
        @NotBlank(message = "ISBN Can't be empty")
        @Pattern(
                regexp = "^([\\d]{10}|[\\d]{13})$",
                message = "ISBN must be 10 or 13 characters long"
        )
        String isbn,
        @NotBlank(message = "title can't be empty") String title,
        @NotBlank(message = "author can't be empty") String author,
        @NotNull(message = "Book must have a price")
        @Positive(message = "price can't be negative") Double price,
        String publisher,
        @CreatedDate Instant createdDate,
        @LastModifiedDate Instant lastModifiedDate,
        @Version int version ) {

        public static Book of(String isbn, String title, String author, Double price, String publisher) {
                return new Book(null, isbn, title, author, price, publisher, null, null,0);
        }
}
