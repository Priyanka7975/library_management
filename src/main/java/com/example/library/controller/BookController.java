package com.example.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.Book;
import com.example.library.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
    Logger log = LoggerFactory.getLogger(BookController.class);

    @GetMapping("/")
    public ResponseEntity<String> homePage() {
        log.info("Home page is called...");
        return ResponseEntity.status(200).body("Welcome To Home Page");
    }

    @Autowired
    private BookService bookService;
    

    @PostMapping("/save")
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        log.info("New book data saved: " + book);
        return bookService.saveBook(book);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }

    

    @GetMapping("/get/")
    public ResponseEntity<Object> getBook11(@RequestHeader int id) {
        return bookService.getBook(id);
    }

    @GetMapping("/get/all")
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/get/byTitle")
    public ResponseEntity<Object> findBookByTitle(@RequestHeader String title) {
        return bookService.getBookByTitle(title);
    }
    
    @DeleteMapping("/delete/{id}")
//    @PreAuthorize("hasRole('USER')")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return "Book deleted!";
    }
}

