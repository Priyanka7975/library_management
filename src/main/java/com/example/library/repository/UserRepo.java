package com.example.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
      List<User> findAll();
}
