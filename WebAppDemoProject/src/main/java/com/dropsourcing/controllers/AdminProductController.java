package com.dropsourcing.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dropsourcing.entities.Product;
import com.dropsourcing.playloads.ProductDto;
import com.dropsourcing.services.CategoryServices;
import com.dropsourcing.services.ProductServices;

@Controller
public class AdminProductController {
	
	public static String uploadDir=System.getProperty("user.dir")+"/src/main/resources/static/productImages";
	
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
	
	
	@PostMapping("/admin/products/add")
	public String addProduct(@ModelAttribute("productDTO") ProductDto productDto,
							 @RequestParam("productImage") MultipartFile file,
							 @RequestParam("imgName") String imgName)throws IOException {
		
		Product product=new Product();
		
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setCategory(categoryServices.getCategoryById(productDto.getCategoryId()).get());
		product.setPrice(productDto.getPrice());
		product.setWeight(productDto.getWeight());
		product.setDescription(productDto.getDescription());
		
		String imageUUID;
		if (!file.isEmpty()) {
			imageUUID=file.getOriginalFilename();
			Path fileNameAndPath=Paths.get(uploadDir,imageUUID);
			Files.write(fileNameAndPath,file.getBytes());
			
		} else {

			imageUUID=imgName;
		}
		
		product.setImageName(imageUUID);
		
		productServices.addProduct(product);
		
		return "redirect:/admin/products";
	}
	
	
	@GetMapping("/admin/product/delete/{id}")
	public String delProduct(@PathVariable long id) {
		productServices.delProductById(id);
		return "redirect:/admin/products";
	}
	
	
	
	@GetMapping("/admin/product/update/{id}")
	public String updateCategorById(@PathVariable long id, Model model) {
		Product getProductFromDB=productServices.getProductById(id).get();
		
		ProductDto productDto=new ProductDto();
		
		productDto.setId(getProductFromDB.getId());
		productDto.setName(getProductFromDB.getName());
		productDto.setCategoryId(getProductFromDB.getCategory().getId());
		productDto.setPrice(getProductFromDB.getPrice());
		productDto.setWeight(getProductFromDB.getWeight());
		productDto.setDescription(getProductFromDB.getDescription());
		productDto.setImageName(getProductFromDB.getImageName());
		
		model.addAttribute("productDTO",productDto);
		model.addAttribute("categories", categoryServices.getAllCategory());
		return "productsAdd";
	}
}
