package com.myresto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myresto.dao.ICommandDao;
import com.myresto.domaine.Command;
@Service("CommandService")
public class CommandService {

	@Autowired
	private ICommandDao iCommandDao;
	public CommandService() {
		
	}
	public CommandService(ICommandDao iCommandDao) {
		super();
		this.iCommandDao = iCommandDao;
	}

	public Command getCommandById( int id ) {
		return iCommandDao.getCommandById(id);
	}
	public List<Command> getAllCommands(){
		return iCommandDao.getAllCommands();
	}
	
	public void createCommand(Command c) {
		iCommandDao.createCommand(c);
	}
	public void updateCommand(Command c) {
		iCommandDao.updateCommand(c);
	}
	public void deleteCommand(int id) {
		iCommandDao.deleteCommand(id);
	}
}
