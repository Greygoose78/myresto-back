package com.myresto.domaine;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@EnableAutoConfiguration
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int idType;
	private String name;
	private double price;
	
	//Constructors
	public Product(int id, int idType, String name, double price) {
		super();
		this.id = id;
		this.idType = idType;
		this.name = name;
		this.price = price;
	}
	
	public Product() {
		super();	
	}
	
	public Product(int idType,String name, double price) {
		super();
		this.idType = idType;
		this.name = name;
		this.price = price;
	}

	//Getters
	public int getId() {
		return id;
	}

	public int getIdType() {
		return idType;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	//Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	

}
