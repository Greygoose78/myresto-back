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
public class CommandeProduit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int idCommande;
	private int [] idProduit;
	private int qte;
	private boolean menu;
	private double prixTotal;
	List<Produit> produits= new ArrayList<Produit>();
	Commande commandes;
	
	//Constructors
	public CommandeProduit() {
		super();
	}
	
	public CommandeProduit(int id, int idCommande, int qte, boolean menu) {
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

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Commande getCommandes() {
		return commandes;
	}

	public void setCommandes(Commande commandes) {
		this.commandes = commandes;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
	
}
