package com.example.catalogservice.book.repository;

import com.example.catalogservice.book.domain.Book;
import com.example.catalogservice.config.DataConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJdbcTest
@Import(DataConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration")
class BookRepositoryJdbcTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JdbcAggregateTemplate jdbcAggregateTemplate;

    @Test
    void findBookByIsbnWhenExisting() {
        // given
        var isbn = "978-3-86680-192-9";
        var book = Book.of(isbn, "Book Title", "Author", 500.0, "publisher");
        jdbcAggregateTemplate.insert(book);

        // when
        Optional<Book> byIsbn = bookRepository.findByIsbn(isbn);
        // then
        assertTrue(byIsbn.isPresent());
        assertEquals(isbn, byIsbn.get().isbn());
    }

}