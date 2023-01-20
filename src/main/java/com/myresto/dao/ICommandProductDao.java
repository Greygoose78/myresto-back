package com.myresto.dao;
import java.util.List;

import com.myresto.domaine.*;
public interface ICommandProductDao {
	List<CommandProduct> getAllCommandProduct();
	public List<Product> getAllProductsByCommand(List<Integer> listId);
	void createCommandProduct(CommandProduct cp);
	void updateCommandProduct(CommandProduct cp);
	void deleteCommandProduct(int id);
}
