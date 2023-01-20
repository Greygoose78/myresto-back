package com.myresto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myresto.dao.ICommandProductDao;
import com.myresto.domaine.CommandProduct;

@Service("CommandProductService")
public class CommandProductService {

	@Autowired
	private ICommandProductDao iCommandProductDao;
	
	public CommandProductService() {
		
	}
	public CommandProductService(ICommandProductDao iCommandeProduitDao) {
		super();
		this.iCommandProductDao = iCommandeProduitDao;
	}
	public List<CommandProduct> getAllCommandProduct(){
		return iCommandProductDao.getAllCommandProduct();
	}
	public void createCommandProduct(CommandProduct cp) {
		iCommandProductDao.createCommandProduct(cp);
	}
	public void updateCommandProduct(CommandProduct cp) {
		iCommandProductDao.updateCommandProduct(cp);
	}
	public void deleteCommandProduct(int id) {
		iCommandProductDao.deleteCommandProduct(id);
	}
}
	