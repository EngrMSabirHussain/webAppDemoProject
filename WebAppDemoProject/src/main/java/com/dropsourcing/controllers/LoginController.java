package com.dropsourcing.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dropsourcing.entities.Role;
import com.dropsourcing.entities.User;
import com.dropsourcing.repositiors.RoleRepo;

@Controller
public class LoginController {
	
	@Autowired
	RoleRepo roleRepo;
	
	@GetMapping("/login")
	public String login() {
		return"login";
	}
	
	
	@GetMapping("/register")
	public String registerUser() {
		return"register";
	}
	
	
	
	@PostMapping("/register")
	public String registerNewUser(@ModelAttribute("user") User user) {
		List<Role> roles=new ArrayList<>();
		roles.add(roleRepo.findById(2).get());
		return"register";
	}
	

}
