package com.example.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

	
     
	List<Book> findByTitle(String title);
	List<Book> findByTitleAndAuthorOrderByPrice(String title, String author); 
	List<Book> findByTitleOrAuthor(String title, String author);

}
