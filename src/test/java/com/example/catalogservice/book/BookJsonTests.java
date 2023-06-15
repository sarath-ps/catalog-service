package com.example.catalogservice.book;

import com.example.catalogservice.book.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookJsonTests {

    @Autowired
    JacksonTester<Book> json;

    @Test
    void testSerialize() throws Exception {
        Book book = new Book("1234567890", "Title", "Author", 9.99);
        JsonContent<Book> content = json.write(book);

        assertThat(content).hasJsonPathStringValue("@.isbn");

        assertThat(content).extractingJsonPathStringValue("@.isbn")
                .isEqualTo(book.isbn());
        assertThat(content).extractingJsonPathStringValue("@.title")
                .isEqualTo(book.title());
        assertThat(content).extractingJsonPathStringValue("@.author")
                .isEqualTo(book.author());
        assertThat(content).extractingJsonPathNumberValue("@.price")
                .isEqualTo(book.price());
    }

    @Test
    void testDeserialize() throws Exception {
        var content = """
                {
                  "isbn": "1234567890",
                  "title": "Title",
                  "author": "Author",
                  "price": 9.90
                }
                """;

        assertThat(json.parse(content))
                .usingRecursiveComparison()
                .isEqualTo(new Book("1234567890", "Title", "Author", 9.90));
    }
}
