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

import com.myresto.domaine.Produit;
import com.myresto.service.ProduitService;

@RestController
@CrossOrigin
public class ProduitController {
	
	@Autowired
	private ProduitService produitService;

	
	@GetMapping("/products")
	public List<Produit> get(){
		return produitService.getAllProducts();
	}

	@GetMapping("/product/{id}")
	public Produit getProductById(@PathVariable("id") int id){
		return produitService.getProductById(id);
	}

	@PostMapping("/product/create")
	public void createProduct(@RequestBody Produit p) {
		produitService.createProduct(p);
	}
		
	@PutMapping("/product/update")
	public void update(@RequestBody Produit p) {
		produitService.updateProduct(p);
	}
	
	@DeleteMapping("/product/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		produitService.deleteProduct(id);
	}
}
