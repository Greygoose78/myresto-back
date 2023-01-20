package com.myresto.dao;

import java.util.List;

import com.myresto.domaine.Command;

public interface ICommandDao {

	Command getCommandById(int id);
	List<Command> getAllCommands();
	void createCommand(Command c);
	void updateCommand(Command c);
	void deleteCommand(int id);
	
}
