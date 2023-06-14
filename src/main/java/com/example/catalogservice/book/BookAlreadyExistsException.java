package com.example.catalogservice.book;

public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String isbn) {
        super("Book with isbn " + isbn + " already exists");
    }
}
