package com.example.catalogservice.book;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        super("Book with isbn " + isbn + " not found");
    }
}
