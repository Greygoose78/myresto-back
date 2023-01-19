package com.myresto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myresto.domaine.CommandeProduit;
import com.myresto.service.CommandeProduitService;

public class CommandeProduitController {
	
	@Autowired
	private CommandeProduitService commandeProduitService;
	
	@PostMapping("/CommandeProduit")
	public void create(@RequestBody CommandeProduit cp) {
		commandeProduitService.createCommandeProduit(cp);;
	}
	
	@PutMapping("/CommandeProduit")
	public void update(@RequestBody CommandeProduit cp) {
		commandeProduitService.updateCommandeProduit(cp);
	}
	
	@DeleteMapping("/CommandeProduit")
	public void delete(@RequestBody int id) {
		commandeProduitService.deleteCommandeProduit(id);;
	}
	
	@GetMapping("/CommandeProduit")
	public List<CommandeProduit> get(){
		return commandeProduitService.getAllCommandeProduit();
	}
}
