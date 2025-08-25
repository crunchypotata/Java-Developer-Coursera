package com.library.digilib.service;

import com.library.digilib.model.Book;
import com.library.digilib.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book findBookById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
}
