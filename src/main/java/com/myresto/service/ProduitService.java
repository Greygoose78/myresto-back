package com.myresto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myresto.dao.IProduitDao;
import com.myresto.domaine.Produit;

@Service("ProduitService")
public class ProduitService {
	
	@Autowired
	private IProduitDao iProduitDao;
	
	public ProduitService() {
	}

	public ProduitService(IProduitDao iProduitDao) {
		super();
		this.iProduitDao = iProduitDao;
	}
	
	public List<Produit> getAllProducts(){
		return iProduitDao.getAllProducts();
	}

	public Produit getProductById(int id){
		return iProduitDao.getProductById(id);
	}
	
	public void createProduct(Produit p) {
		iProduitDao.createProduct(p);
	}
	public void updateProduct(Produit p) {
		iProduitDao.updateProduct(p);
	}
	public void deleteProduct(int id) {
		iProduitDao.deleteProduct(id);
	}
	

}
