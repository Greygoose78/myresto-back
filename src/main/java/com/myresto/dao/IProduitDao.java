package com.myresto.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myresto.domaine.Commande;
import com.myresto.domaine.Produit;

@Service
public interface IProduitDao {
	List<Produit> getAllProducts();
	void createProduct(Produit p);
	Produit getProductById( int id );
	void updateProduct(Produit p);
	void deleteProduct(int id);
}
