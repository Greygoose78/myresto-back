package com.myresto.domaine;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@EnableAutoConfiguration
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String mail;
	private String password;
	private String username;
	private String address;
	private String phone;
	private boolean manager;

	
	
	public User() {
		
	}
	
	public User(int id, String mail, String username, String address, String phone, boolean manager) {
		super();
		this.id = id;
		this.mail = mail;
		this.username = username;
		this.address = address;
		this.phone = phone;
		this.manager = manager;
	}
	
	public User(String mail, String password, String username, String address, String phone, boolean manager) {
		super();
		this.mail = mail;
		this.password = password;
		this.username = username;
		this.address = address;
		this.phone = phone;
		this.manager = manager;
	}

	public User(int id, String mail, String password, String username, String address, String phone, boolean manager) {
		super();
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.username = username;
		this.address = address;
		this.phone = phone;
		this.manager = manager;
	}


	//Getters
	public int getId() {
		return id;
	}


	public String getMail() {
		return mail;
	}


	public String getPassword() {
		return password;
	}


	public String getUsername() {
		return username;
	}


	public String getAddress() {
		return address;
	}


	public String getPhone() {
		return phone;
	}


	public boolean isManager() {
		return manager;
	}

	
	//Setters
	public void setId(int id) {
		this.id = id;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setManger(boolean manager) {
		this.manager = manager;
	}
	
}
