package com.example.demo;

import com.example.demo.controller.BookController;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class BookControllerIntegrationTest {

    private MockMvc mockMvc;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        // Initialize BookService and Controller
        bookService = new BookService();
        BookController bookController = new BookController(bookService);
        // Build MockMVC instance
        mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    void testGetBookById() throws Exception {
        // Add a book to the service
        bookService.saveBook(new Book(1L, "1984", "George Orwell"));

        // Perform GET request and validate the response
        mockMvc.perform(get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("1984"))
                .andExpect(jsonPath("$.author").value("George Orwell"));
    }

    @Test
    void testAddBook() throws Exception {
        // Perform POST request and validate the response
        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": 2, \"title\": \"Brave New World\", \"author\": \"Aldous Huxley\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Brave New World"))
                .andExpect(jsonPath("$.author").value("Aldous Huxley"));
    }
}
