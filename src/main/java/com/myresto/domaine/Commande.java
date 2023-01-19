package com.myresto.domaine;
import java.util.*;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int idUser;
	private Date date;
	
	
	
	
	//Constructors

	public Commande() {
		super();
	}


		public Commande(int id, int idUser, Date date) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.date = date;
	}

	//Getters
	public int getId() {
		return id;
	}
	public int getIdUser() {
	return idUser;
	}



	public Date getDate() {
		return date;
	}


	
	//setters
	public void setId(int id) {
		this.id = id;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
