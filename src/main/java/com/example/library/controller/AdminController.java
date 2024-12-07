package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.entity.User;
import com.example.library.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
    private UserService userService;

    @GetMapping("/getusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
