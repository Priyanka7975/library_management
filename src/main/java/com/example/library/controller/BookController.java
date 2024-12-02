package com.example.library.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        log.info("New book data saved: " + book);
        return bookService.saveBook(book);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getBook1(@RequestParam int id) {
        return bookService.getBook(id);
    }

    @GetMapping("/get1")
    public ResponseEntity<Object> getBook11(@RequestHeader int id) {
        return bookService.getBook(id);
    }

    @GetMapping("/getAll")
    public List<Book> getAll() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getByTitle")
    public ResponseEntity<Object> findBookByTitle(@RequestHeader String title) {
        return bookService.getBookByTitle(title);
    }
}

