package com.library.digilib.controller;

import com.library.digilib.model.Book;
import com.library.digilib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable long id) {
        Book foundBook = bookService.findBookById(id);
        if (foundBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Book with ID " + id + " not found.");
        }
        EntityModel<Book> resource = EntityModel.of(foundBook);
        resource.add(linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel());

        // HATEOAS links based on the book's availability
        if (foundBook.isAvailable()) {
            resource.add(linkTo(methodOn(BookController.class).borrowBook(id)).withRel("borrow"));
        } else {
            resource.add(linkTo(methodOn(BookController.class).returnBook(id)).withRel("return"));
        }

        return ResponseEntity.ok(resource);
    }

    @PostMapping("/{id}/borrow")
    public ResponseEntity<?> borrowBook(@PathVariable long id) {

        Book foundBook = bookService.findBookById(id);
        if (foundBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Book with ID " + id + " not found.");
        }
        if (!foundBook.isAvailable()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Book with ID " + id + " is already borrowed.");
        }

        // Mark the book as borrowed
        foundBook.setAvailable(false);
        bookService.updateBook(foundBook);

        // Return the updated book with a self link to the book's current state
        return ResponseEntity.ok(EntityModel.of(foundBook, linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel()));
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<?> returnBook(@PathVariable long id) {

        Book foundBook = bookService.findBookById(id);

        if (foundBook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Book with ID " + id + " not found.");
        }
        if (foundBook.isAvailable()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Book with ID " + id + " has already been returned.");
        }
        foundBook.setAvailable(true);
        bookService.updateBook(foundBook);

        return ResponseEntity.ok(EntityModel.of(foundBook, linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel()));
    }
}
