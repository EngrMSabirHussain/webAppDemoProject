package com.dropsourcing.playloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

	
	private long id;
	
	private String name;
	
	private int categoryId;
	
	private double price;
	
	private double weight;
	
	private String description;
	
	private String imageName;
}
