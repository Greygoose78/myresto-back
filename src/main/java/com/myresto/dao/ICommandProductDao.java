package com.myresto.dao;
import java.util.List;

import com.myresto.domaine.*;
public interface ICommandProductDao {
	List<CommandProduct> getAllCommandProduct();
	List<Integer> getProductByCommandId(int id );
	List<Product> getAllProductsByCommand(List<Integer> listId);
	void createCommandProduct(CommandProduct cp);
	void updateCommandProduct(CommandProduct cp);
	void deleteCommandProduct(int id);
}
