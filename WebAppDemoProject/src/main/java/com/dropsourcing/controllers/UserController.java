package com.dropsourcing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dropsourcing.entities.User;
import com.dropsourcing.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServices userServices;

	@GetMapping("/add")
	public User createUser(@RequestBody User user) {
		return userServices.createUser(user);
	}
}
