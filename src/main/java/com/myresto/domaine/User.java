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
	private String tel;
	private boolean gerant;

	
	public User(int id, String mail, String password, String username, String address, String tel, boolean gerant) {
		super();
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.username = username;
		this.address = address;
		this.tel = tel;
		this.gerant = gerant;
	}
	
	public User() {
		
	}
	
	public User(int id, String mail, String username, String address, String tel, boolean gerant) {
		super();
		this.id = id;
		this.mail = mail;
		this.username = username;
		this.address = address;
		this.tel = tel;
		this.gerant = gerant;
	}
	
	public User(String mail, String password, String username, String address, String tel, boolean gerant) {
		super();
		this.mail = mail;
		this.password = password;
		this.username = username;
		this.address = address;
		this.tel = tel;
		this.gerant = gerant;
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


	public String getTel() {
		return tel;
	}


	public boolean isGerant() {
		return gerant;
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


	public void setTel(String tel) {
		this.tel = tel;
	}


	public void setGerant(boolean gerant) {
		this.gerant = gerant;
	}

	
	
	
}
