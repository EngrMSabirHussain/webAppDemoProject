package com.dropsourcing.repositiors;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dropsourcing.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {


	List<Product> getAllProductByCategoryId(int id);
}
