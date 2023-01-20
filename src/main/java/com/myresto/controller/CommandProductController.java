package com.myresto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myresto.domaine.CommandProduct;
import com.myresto.service.CommandProductService;

public class CommandProductController {
	
	@Autowired
	private CommandProductService commandeProduitService;
	
	@PostMapping("/CommandeProduit")
	public void create(@RequestBody CommandProduct cp) {
		commandeProduitService.createCommandeProduit(cp);;
	}
	
	@PutMapping("/CommandeProduit")
	public void update(@RequestBody CommandProduct cp) {
		commandeProduitService.updateCommandeProduit(cp);
	}
	
	@DeleteMapping("/CommandeProduit")
	public void delete(@RequestBody int id) {
		commandeProduitService.deleteCommandeProduit(id);;
	}
	
	@GetMapping("/CommandeProduit")
	public List<CommandProduct> get(){
		return commandeProduitService.getAllCommandeProduit();
	}
}
