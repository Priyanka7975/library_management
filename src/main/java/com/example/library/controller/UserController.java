package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.Book;
import com.example.library.entity.User;
import com.example.library.service.BookService;
import com.example.library.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private BookService bookService;
	@PostMapping("/save") 
//	@PreAuthorize("hasAuthority('ADMIN')") 
	public ResponseEntity<ResponseEntity<String>> createUser(@RequestBody User user) {
		ResponseEntity<String> savedUser = userService.saveUser(user);
		return ResponseEntity.ok(savedUser); 
		} 
	 @PutMapping("/approve/{id}")
	    public ResponseEntity<Object> approveUser(@PathVariable Long id) {
		 
              System.out.print("Hi");
              return userService.approveUser(id);
	    }
	
}
