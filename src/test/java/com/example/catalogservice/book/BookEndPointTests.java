package com.example.catalogservice.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookEndPointTests {

    @Autowired
    WebTestClient testClient;

    @Test
    void whenPostBookWithInvalidIsbn_thenBadRequest() {
        testClient.post()
                .uri("/books")
                .bodyValue(new Book("123456789", "Title", "Author", 9.99))
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void whenPostRequestThenBookIsCreated() {
        WebTestClient.BodySpec<Book, ?> bookBodySpec = testClient.post()
                .uri("/books")
                .bodyValue(new Book("1234567890", "Title", "Author", 9.99))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Book.class)
                .value(book -> {
                    assertThat(book).isNotNull();
                    assertThat(book.isbn()).isEqualTo("1234567890");
                    assertThat(book.title()).isEqualTo("Title");
                    assertThat(book.author()).isEqualTo("Author");
                    assertThat(book.price()).isEqualTo(9.99);
                });
    }

}
