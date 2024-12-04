package com.example.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.library.entity.Book;
import com.example.library.repository.BookRepo;
@Service
public class BookService implements BookServiceMethods{
	@Autowired
	private BookRepo bookRepo;

	@Override
	public ResponseEntity<Book> saveBook(Book book) {
		return ResponseEntity.status(201).body(bookRepo.save(book));
	}

	@Override
	public ResponseEntity<Object> getBook(int id) {
		
		Optional<Book> book=bookRepo.findById(id);
		if(book.isPresent()) {
			return ResponseEntity.status(200).body(book);
		}else {
			return ResponseEntity.status(404).body("No book found with the given Id");
			
		}
		
	}

	@Override
	public List<Book> getAllBooks() {

		
		return bookRepo.findAll();
	}

	@Override
	public ResponseEntity<Object> getBookByTitle(String title) {
       List<Book> bookList=bookRepo.findByTitle(title);
       if(!bookList.isEmpty()) {
    	   return ResponseEntity.status(200).body(bookList);
		}else {
			return ResponseEntity.status(404).body("No book found with the given title");
			
		} 
       
		}
	public ResponseEntity<Object> deleteById(Long id) {
	    Optional<Book> book = bookRepo.findById(id);
	    if (book.isPresent()) {
	        bookRepo.deleteById(id);
	        return ResponseEntity.status(200).body("Book with ID " + id + " has been deleted successfully.");
	    } else {
	        return ResponseEntity.status(404).body("No book found with the given ID.");
	    }
	}
	

}
