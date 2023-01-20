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
		return iCommandeProduitDao.getAllCommandProduct();
	}
	public void createCommandeProduit(CommandProduct cp) {
		iCommandeProduitDao.createCommandProduct(cp);
	}
	public void updateCommandeProduit(CommandProduct cp) {
		iCommandeProduitDao.updateCommandProduct(cp);
	}
	public void deleteCommandeProduit(int id) {
		iCommandeProduitDao.deleteCommandProduct(id);
	}
}
	