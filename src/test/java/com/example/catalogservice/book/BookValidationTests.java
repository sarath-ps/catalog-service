package com.example.catalogservice.book;

import com.example.catalogservice.book.domain.Book;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


public class BookValidationTests {

    private static Validator validator;

    @BeforeAll
    public static void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void WhenAllFieldsAreValid_ThenValidationSucceeds() {
        Book book = Book.of("1234567890", "Title", "Author", 9.99, "publisher");
        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        assertThat(violations).isEmpty();
    }

    @Test
    void whenIsbnIsInvalid_ThenValidationFails() {
        Book book = Book.of("123456789", "Title", "Author", 9.99, "publisher");
        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("ISBN must be 10 or 13 characters long");
    }
}
