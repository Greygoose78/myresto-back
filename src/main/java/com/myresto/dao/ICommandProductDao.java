package com.myresto.dao;
import java.util.List;

import com.myresto.domaine.*;
public interface ICommandProductDao {
	List<CommandProduct> getAllCommandeProduit();
	void createCommandeProduit(CommandProduct cp);
	void updateCommandeProduit(CommandProduct cp);
	void deleteCommandeProduit(int id);
}
