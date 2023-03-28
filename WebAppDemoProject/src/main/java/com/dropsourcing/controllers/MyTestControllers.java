package com.dropsourcing.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyTestControllers {

	@GetMapping("/home")
	public String test() {
		return "Run Successfully on Tomcat";
	}
}
