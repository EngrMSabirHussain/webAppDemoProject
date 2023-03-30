package com.dropsourcing.services.Impls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dropsourcing.entities.Product;
import com.dropsourcing.repositiors.ProductRepo;
import com.dropsourcing.services.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices {
	
	@Autowired
	ProductRepo productRepo;
	
	@Override
	public void addProduct(Product product) {
		productRepo.save(product);
		
	}
	
	
	@Override
	public Optional<Product> getProductById(long id) {
		return productRepo.findById(id);
	}
	
	

	@Override
	public List<Product> getAllProducts() {	
		return productRepo.findAll();
	}



	@Override
	public void delProductById(long id) {
		productRepo.deleteById(id);
		
	}


	@Override
	public List<Product> getAllProductsByCategoryId(int id) {
		
		return productRepo.getAllProductByCategoryId(id);
	}



	

}
