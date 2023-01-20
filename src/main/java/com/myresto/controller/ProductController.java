package com.myresto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myresto.domaine.Product;
import com.myresto.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService produitService;

	
	@GetMapping("/products")
	public List<Product> get(){
		return produitService.getAllProducts();
	}

	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable("id") int id){
		return produitService.getProductById(id);
	}

	@PostMapping("/product/create")
	public void createProduct(@RequestBody Product p) {
		produitService.createProduct(p);
	}
		
	@PutMapping("/product/update")
	public void update(@RequestBody Product p) {
		produitService.updateProduct(p);
	}
	
	@DeleteMapping("/product/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		produitService.deleteProduct(id);
	}
}
