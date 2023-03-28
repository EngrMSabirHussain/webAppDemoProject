package com.dropsourcing.services;

import java.util.List;
import java.util.Optional;

import com.dropsourcing.entities.Category;

public interface CategoryServices {
	
	public void addCategor(Category category );
	
	public List<Category> getAllCategory();
	
	public void delCategoryById(int id);
	
	public Optional<Category> getCategoryById(int id);
	
	

}
