package com.dropsourcing.repositiors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dropsourcing.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
