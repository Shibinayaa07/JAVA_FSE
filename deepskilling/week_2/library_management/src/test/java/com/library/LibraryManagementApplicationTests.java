package com.library;

import com.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@ImportResource("classpath:applicationContext.xml")
class LibraryManagementApplicationTests {
    @Autowired
    private BookService bookService;

    @Test
    void contextLoadsAndInjectsBookService() {
        assertFalse(bookService.getAllBooks().isEmpty());
    }
}
