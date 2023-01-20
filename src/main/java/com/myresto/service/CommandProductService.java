package com.myresto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myresto.dao.ICommandProductDao;
import com.myresto.domaine.CommandProduct;

@Service("CommandeProduitService")
public class CommandProductService {

	@Autowired
	private ICommandProductDao iCommandeProduitDao;
	
	public CommandProductService() {
		
	}
	public CommandProductService(ICommandProductDao iCommandeProduitDao) {
		super();
		this.iCommandeProduitDao = iCommandeProduitDao;
	}
	public List<CommandProduct> getAllCommandeProduit(){
		return iCommandeProduitDao.getAllCommandeProduit();
	}
	public void createCommandeProduit(CommandProduct cp) {
		iCommandeProduitDao.createCommandeProduit(cp);
	}
	public void updateCommandeProduit(CommandProduct cp) {
		iCommandeProduitDao.updateCommandeProduit(cp);
	}
	public void deleteCommandeProduit(int id) {
		iCommandeProduitDao.deleteCommandeProduit(id);
	}
}
	