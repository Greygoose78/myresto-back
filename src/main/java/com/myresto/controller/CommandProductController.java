package com.myresto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myresto.domaine.CommandProduct;
import com.myresto.service.CommandProductService;

@RestController
@CrossOrigin
public class CommandProductController {
	
	@Autowired
	private CommandProductService commandProductService;

	@GetMapping("/command/products")
	public List<CommandProduct> get(){
		return commandProductService.getAllCommandProduct();
	}

	@PostMapping("/command/product/create")
	public void create(@RequestBody CommandProduct cp) {
		commandProductService.createCommandProduct(cp);;
	}
	
	@PutMapping("/command/product/update")
	public void update(@RequestBody CommandProduct cp) {
		commandProductService.updateCommandProduct(cp);
	}
	
	@DeleteMapping("/command/product/delete/{id}")
	public void delete(@RequestBody int id) {
		commandProductService.deleteCommandProduct(id);;
	}
}
