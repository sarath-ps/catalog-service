package com.example.catalogservice.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> findAll() {
        return bookService.viewBookList();
    }

    @GetMapping("/{isbn}")
    public Book findByIsbn(@PathVariable String isbn) {
        return bookService.viewBookDetails(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody @Valid Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBook(@PathVariable String isbn) {
        bookService.removeBook(isbn);
    }

    @PutMapping("/{isbn}")
    public Book editBookDetails(@PathVariable String isbn, @RequestBody @Valid Book book) {
        return bookService.editBookDetails(isbn, book);
    }
}
