package com.dropsourcing.services.Impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dropsourcing.entities.Category;
import com.dropsourcing.repositiors.CategoryRepo;
import com.dropsourcing.services.CategoryServices;


@Service
public class CategoryServicesImpl implements CategoryServices{
	
	@Autowired
	CategoryRepo categoryRepo;

	@Override
	public void addCategor(Category category) {
		categoryRepo.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepo.findAll();
	}

	@Override
	public void delCategoryById(int id) {
		categoryRepo.deleteById(id);
		
	}

	@Override
	public Optional<Category> getCategoryById(int id) {
		return categoryRepo.findById(id);
	}



}
