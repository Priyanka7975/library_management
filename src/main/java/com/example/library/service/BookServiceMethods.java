package com.example.library.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.library.entity.Book;
@Service
public interface BookServiceMethods {
	
	
	ResponseEntity<Book> saveBook(Book book);
	ResponseEntity<Object> getBook(int id);
	List<Book> getAllBooks();
	ResponseEntity<Object> getBookByTitle(String title);
	ResponseEntity<Object> deleteById(Long id);
}
