package com.dropsourcing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dropsourcing.services.CategoryServices;
import com.dropsourcing.services.ProductServices;

@Controller
public class HomeController {
	
	@Autowired
	ProductServices productServices;
	
	@Autowired
	CategoryServices categoryServices;
	
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		return "index";
	}
	
	@GetMapping("/shop")
	public String shop(Model model) {
		
		model.addAttribute("categories", categoryServices.getAllCategory());
		model.addAttribute("products", productServices.getAllProducts());
		return "shop";
	}
	
	
	@GetMapping("/shop/category/{id}")
	public String shopByCategoryId(Model model, @PathVariable int id) {
		
		model.addAttribute("categories", categoryServices.getAllCategory());
		model.addAttribute("products", productServices.getAllProductsByCategoryId(id));
		return "shop";
	}

	
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProductById(Model model, @PathVariable int id) {
		model.addAttribute("product", productServices.getProductById(id).get());
		return "viewProduct";
	}

}
