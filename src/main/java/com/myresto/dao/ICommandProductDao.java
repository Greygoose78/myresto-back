package com.myresto.dao;
import java.util.List;

import com.myresto.domaine.*;
public interface ICommandProductDao {
	List<CommandProduct> getAllCommandProduct();
	List<Product> getAllProductsByCommand(List<Integer> listId);
	List<Product> getProductsByCommandId(List<Product> products);
	void createCommandProduct(CommandProduct cp);
	void updateCommandProduct(CommandProduct cp);
	void deleteCommandProduct(int id);
}
