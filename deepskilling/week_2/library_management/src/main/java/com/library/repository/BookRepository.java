package com.library.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private final List<String> books = new ArrayList<>();

    public BookRepository() {
        books.add("Clean Code");
        books.add("Effective Java");
    }

    public List<String> findAllBooks() {
        return books;
    }

    public void addBook(String bookName) {
        books.add(bookName);
    }
}
