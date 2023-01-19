package com.myresto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myresto.dao.ICommandeDao;
import com.myresto.domaine.Commande;
@Service("CommandeService")
public class CommandeService {

	@Autowired
	private ICommandeDao iCommandeDao;
	public CommandeService() {
		
	}
	public CommandeService(ICommandeDao iCommandeDao) {
		super();
		this.iCommandeDao = iCommandeDao;
	}
	
	public void createCommande(Commande c) {
		iCommandeDao.createCommande(c);
	}
	public void updateCommande(Commande c) {
		iCommandeDao.updateCommande(c);
	}
	public Commande getCommandeById( int id ) {
		return iCommandeDao.getCommandeById(id);
	}
	public List<Commande> getAllCommande(){
		return iCommandeDao.getAllCommande();
	}
	public void deleteCommande(int id) {
		iCommandeDao.deleteCommande(id);
	}
}
