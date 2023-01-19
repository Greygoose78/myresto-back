package com.myresto.dao;

import java.util.List;

import com.myresto.domaine.Commande;

public interface ICommandeDao {
	void createCommande(Commande c);
	Commande getCommandeById( int id );
	List<Commande> getAllCommande();
	void updateCommande(Commande c);
	void deleteCommande(int id);
	
	
}
