package com.dropsourcing.services;

import java.util.List;
import java.util.Optional;

import com.dropsourcing.entities.Product;

public interface ProductServices {
	
	//add product
		public void addProduct(Product product);
		
	// get product by id
		public Optional<Product> getProductById(long id);
		
	//remove product
		public void delProductById(long id);
	
	//get All Product form Database
		public List<Product> getAllProducts();
	
	//get All Product by Category Id
		public List<Product> getAllProductsByCategoryId(int id);
	

}
