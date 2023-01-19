package com.myresto.domaine;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@EnableAutoConfiguration
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int idType;
	private String libelle;
	private double prix;
	
	//Constructors
	public Produit(int id, int idType, String libelle, double prix) {
		super();
		this.id = id;
		this.idType = idType;
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Produit() {
		super();	
	}
	
	public Produit(int idType,String libelle, double prix) {
		super();
		this.idType = idType;
		this.libelle = libelle;
		this.prix = prix;
	}

	//Getters
	public int getId() {
		return id;
	}

	public int getidType() {
		return idType;
	}

	public String getLibelle() {
		return libelle;
	}

	public double getPrix() {
		return prix;
	}

	//Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setidType(int idType) {
		this.idType = idType;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
	

}
