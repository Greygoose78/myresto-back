package com.myresto.dao;
import java.util.List;

import com.myresto.domaine.*;
public interface ICommandeProduitDao {
	List<CommandeProduit> getAllCommandeProduit();
	void createCommandeProduit(CommandeProduit cp);
	void updateCommandeProduit(CommandeProduit cp);
	void deleteCommandeProduit(int id);
}
