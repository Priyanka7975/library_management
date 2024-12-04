package com.example.library.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.library.entity.User;
import com.example.library.repository.UserRepo;

@Service
public class UserService {
	@Autowired 
	private UserRepo userRepo; 
	@Autowired 
	private PasswordEncoder passwordEncoder; 
	public User saveUser(User user) { 
		user.setPassword(passwordEncoder.encode(user.getPassword())); 
		return userRepo.save(user); 
		} 
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	
	public ResponseEntity<Object> approveUser(Long userId) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setApprovedByAdmin(true);
            userRepo.save(existingUser);
            return ResponseEntity.status(200).body("User approved successfully.");
        } else {
            return ResponseEntity.status(404).body("User not found.");
        }
    }
}
