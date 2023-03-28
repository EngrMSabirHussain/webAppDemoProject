package com.dropsourcing.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.dropsourcing.entities.Category;
import com.dropsourcing.services.CategoryServices;


@Controller
public class AdminCategoryController {
	
	@Autowired
	CategoryServices cateServices;

	
	// use to show Admit home page 
	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
	}
	
	// use to show admin categories page and also show all category on it by getting from database
	@GetMapping("/admin/categories")
	public String getCategories(Model model) {
		model.addAttribute("categories", cateServices.getAllCategory());
		return "categories";
	}
	
	// Add categories 
	@GetMapping("/admin/categories/add")
	public String addCategories(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String postCategoriesName(@ModelAttribute("category") Category category) {
		cateServices.addCategor(category);
		return "redirect:/admin/categories";
	}
	
	
	@GetMapping("/admin/categories/delete/{id}")
	public String delCategorById(@PathVariable int id) {
		cateServices.delCategoryById(id);
		return "redirect:/admin/categories";
	}
	
	
	@GetMapping("/admin/categories/update/{id}")
	public String updateCategorById(@PathVariable int id, Model model) {
		Optional<Category> getCategory=cateServices.getCategoryById(id);
		
		if(getCategory.isPresent()) {
			model.addAttribute("category", getCategory.get());
			return "categoriesAdd";
		}else {
			return "404";
		}
	}
	
	
}
