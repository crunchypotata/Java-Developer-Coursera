package com.example.demo;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService();
    }

    @Test
    void testSaveBook() {
        Book book = new Book(1L, "1984", "George Orwell");

        Book savedBook = bookService.saveBook(book);

        assertNotNull(savedBook, "The saved book should not be null.");
        assertEquals(1L, savedBook.getId(), "The ID should match the saved book.");
        assertEquals("1984", savedBook.getTitle(), "The title should match the saved book.");
        assertEquals("George Orwell", savedBook.getAuthor(), "The author should match the saved book.");
    }

    @Test
    void testGetBookById() {
        Book book = new Book(1L, "1984", "George Orwell");
        bookService.saveBook(book);

        //Save the object
        Book retrievedBook = bookService.getBookById(1L);

        assertNotNull(retrievedBook, "The retrieved book should not be null.");
        assertEquals(1L, retrievedBook.getId(), "The ID should match the saved book.");
        assertEquals("1984", retrievedBook.getTitle(), "The title should match the saved book.");
        assertEquals("George Orwell", retrievedBook.getAuthor(), "The author should match the saved book.");
    }


    @Test
    void testDeleteBook() {
        Book book = new Book(1L, "1984", "George Orwell");
        bookService.saveBook(book);

        bookService.deleteBook(1L);

        Book deletedBook = bookService.getBookById(1L);
        assertNull(deletedBook, "The book should be null after deletion.");
    }

    @Test
    void testSaveBookValidation() {
        Book invalidBook = new Book(1L, null, "George Orwell");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bookService.saveBook(invalidBook);
        });

        assertEquals("Book title and author must not be null.", exception.getMessage(), "Validation message should match.");
    }

    @Test
    void testEmptyBookCollection() {
        assertNull(bookService.getBookById(1L), "No book should be found in an empty collection.");
    }

    @Test
    void testSaveBookDuplicateId() {
        Book book1 = new Book(1L, "1984", "George Orwell");
        Book book2 = new Book(1L, "Animal Farm", "George Orwell");

        bookService.saveBook(book1);
        bookService.saveBook(book2);

        Book retrievedBook = bookService.getBookById(1L);
        assertEquals("Animal Farm", retrievedBook.getTitle(), "The latest book should overwrite the existing book with the same ID.");
    }
}

