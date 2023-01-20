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
	private int idCommand;
	private int [] idProduct;
	private int qte;
	private boolean menu;
	private double totalPrice;
	List<Product> products = new ArrayList<Product>();
	Command commands;
	
	//Constructors
	public CommandProduct() {
		super();
	}
	
	public CommandProduct(int id, int idCommand, int qte, boolean menu) {
		super();
		this.id = id;
		this.idCommand = idCommand;
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
	public int getIdCommand() {
		return idCommand;
	}
	public void setIdCommand(int idCommand) {
		this.idCommand = idCommand;
	}
	public int [] getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int [] idProduit) {
		this.idProduct = idProduit;
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

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Command getCommands() {
		return commands;
	}

	public void setCommands(Command commands) {
		this.commands = commands;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
