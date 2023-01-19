package com.myresto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myresto.dao.ICommandeProduitDao;
import com.myresto.domaine.CommandeProduit;

@Service("CommandeProduitService")
public class CommandeProduitService {

	@Autowired
	private ICommandeProduitDao iCommandeProduitDao;
	
	public CommandeProduitService() {
		
	}
	public CommandeProduitService(ICommandeProduitDao iCommandeProduitDao) {
		super();
		this.iCommandeProduitDao = iCommandeProduitDao;
	}
	public List<CommandeProduit> getAllCommandeProduit(){
		return iCommandeProduitDao.getAllCommandeProduit();
	}
	public void createCommandeProduit(CommandeProduit cp) {
		iCommandeProduitDao.createCommandeProduit(cp);
	}
	public void updateCommandeProduit(CommandeProduit cp) {
		iCommandeProduitDao.updateCommandeProduit(cp);
	}
	public void deleteCommandeProduit(int id) {
		iCommandeProduitDao.deleteCommandeProduit(id);
	}
}
	