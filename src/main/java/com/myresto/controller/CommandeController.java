package com.myresto.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myresto.domaine.Commande;
import com.myresto.domaine.Produit;
import com.myresto.service.CommandeService;
import com.myresto.service.ProduitService;


@RestController
public class CommandeController {


	@Autowired
	private CommandeService service;
	
	
	@PostMapping("/Commande")
	public void create(@RequestBody Commande commande) {
		service.createCommande(commande);
	}
	@GetMapping("/CommandeById")
	public Commande get(@RequestParam int id) {
		return service.getCommandeById(id);
	}

	@PutMapping("/Commande")
	public void update(@RequestBody Commande commande) {
		service.updateCommande(commande);
	}

	@DeleteMapping("/Commande")
	public void delete(@RequestBody int  id) {
		service.deleteCommande(id);
	}

	@GetMapping("/Commande")
	public List<Commande> get() {
		return service.getAllCommande();
	}


}
