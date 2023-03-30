package com.dropsourcing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PostMapping("/add")
	public User createUser(@RequestBody User user) {
		return userServices.createUser(user);
	}
	
	@DeleteMapping("/delAllUsers")
	public String createUser() {
		this.userServices.delAllUsers();
		return "Delete Succfully";
	}
	
	@PutMapping("/updateUser/{userId}")
	public User updateUser(@RequestBody User user, @PathVariable int userId) {
		
		return this.userServices.updateUser(user, userId);
	}
}
