package com.myresto.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@EnableAutoConfiguration
public class CommandProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int idCommande;
	private int [] idProduit;
	private int qte;
	private boolean menu;
	private double prixTotal;
	List<Product> produits= new ArrayList<Product>();
	Command commands;
	
	//Constructors
	public CommandProduct() {
		super();
	}
	
	public CommandProduct(int id, int idCommande, int qte, boolean menu) {
		super();
		this.id = id;
		this.idCommande = idCommande;
		this.qte = qte;
		this.menu = menu;
	}
	
	//Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}
	public int [] getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int [] idProduit) {
		this.idProduit = idProduit;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public boolean isMenu() {
		return menu;
	}
	public void setMenu(boolean menu) {
		this.menu = menu;
	}

	public List<Product> getProduits() {
		return produits;
	}

	public void setProduits(List<Product> produits) {
		this.produits = produits;
	}

	public Command getCommands() {
		return commands;
	}

	public void setCommands(Command commands) {
		this.commands = commands;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
	
}
