package com.myresto.laucher;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.myresto.domaine.Commande;
import com.myresto.domaine.CommandeProduit;
import com.myresto.domaine.Produit;
import com.myresto.service.CommandeProduitService;
import com.myresto.service.CommandeService;
import com.myresto.service.ProduitService;

@SpringBootApplication(scanBasePackages="com.myresto")
@RestController
public class DemoApplication {
	
	@Autowired
	private ProduitService produitService;
	
	@Autowired
	private CommandeProduitService commandeProduitService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
