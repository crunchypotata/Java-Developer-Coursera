package com.example.demo.service;

import com.example.demo.model.Book;
import java.util.HashMap;
import java.util.Map;

public class BookService {
    private final Map<Long, Book> books = new HashMap<>();

    public Book saveBook(Book book) {
        if (book.getTitle() == null || book.getAuthor() == null) {
            throw new IllegalArgumentException("Book title and author must not be null.");
        }
        books.put(book.getId(), book);
        return book;
    }

    public Book getBookById(Long id) {
        return books.get(id);
    }

    public void deleteBook(Long id) {
        books.remove(id);
    }
}
