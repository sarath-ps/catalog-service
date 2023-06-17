package com.example.catalogservice.book;

import com.example.catalogservice.book.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookEndPointTests {

    @Autowired
    WebTestClient testClient;

    @Test
    @Transactional
    void whenPostBookWithInvalidIsbn_thenBadRequest() {
        testClient.post()
                .uri("/books")
                .bodyValue(Book.of("111345678111122", "Title", "Author", 9.99, "publisher"))
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    @Transactional
    void whenPostRequestThenBookIsCreated() {
        StringBuilder isbnB = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            isbnB.append((int) (Math.random() * 10));
        }
        final String isbn = isbnB.toString();

        WebTestClient.BodySpec<Book, ?> bookBodySpec = testClient.post()
                .uri("/books")
                .bodyValue(Book.of(isbn, "Title", "Author", 9.99, "publisher"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Book.class)
                .value(book -> {
                    assertThat(book).isNotNull();
                    assertThat(book.isbn()).isEqualTo(isbn);
                    assertThat(book.title()).isEqualTo("Title");
                    assertThat(book.author()).isEqualTo("Author");
                    assertThat(book.price()).isEqualTo(9.99);
                });
    }

}
