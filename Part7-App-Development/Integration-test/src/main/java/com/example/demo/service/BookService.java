package com.example.demo.service;

import com.example.demo.model.Book;
import java.util.HashMap;
import java.util.Map;

public class BookService {
    private final Map<Long, Book> books = new HashMap<>();

    public Book saveBook (Book book) {
        books.put(book.getId(), book);
        return book;
    }

    public Book getBookById(Long id) {
        return books.get(id);
    }
}
