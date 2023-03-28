package com.dropsourcing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dropsourcing.playloads.ProductDto;
import com.dropsourcing.services.CategoryServices;
import com.dropsourcing.services.ProductServices;

@Controller
public class AdminProductController {
	
	@Autowired
	ProductServices productServices;
	
	@Autowired
	CategoryServices categoryServices;
	
	@GetMapping("/admin/products")
	public String getAllProducts(Model model) {
		model.addAttribute("products", productServices.getAllProducts());
		return "products";
	}
	
	
	@GetMapping("/admin/products/add")
	public String addProduct(Model model) {
		model.addAttribute("productDTO", new ProductDto());
		model.addAttribute("categories", categoryServices.getAllCategory());
		return "productsAdd";
	}

}
