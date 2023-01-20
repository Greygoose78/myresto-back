package com.myresto.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.myresto.domaine.Command;
import com.myresto.domaine.User;

@CrossOrigin
@Repository
public class CommandDao implements ICommandDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public CommandDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate =jdbcTemplate;
	}
	
	//READ
	public Command getCommandById(int id ) {
		return jdbcTemplate.queryForObject("Select * from command where id="+id, (resultSet, rowNum) -> {
			return new Command(resultSet.getInt("id"),resultSet.getInt("id_user"),resultSet.getDate("date"));
		});
	}

	public List<Command> getAllCommands() {
		return jdbcTemplate.query("Select * from command", (resultSet, rowNum) -> {
			return new Command(resultSet.getInt("id"),resultSet.getInt("id_user"),resultSet.getDate("date"));
		});
	}

	//CREATE
	public void createCommand(Command c) {
		Object[] arguments = new Object[2];
		arguments[0] = c.getIdUser();
		arguments[1] = c.getDate();
		jdbcTemplate.update("INSERT INTO command(id_user,date) VALUES (?,?)", arguments);

	}
	

	public void updateCommand(Command c) {
		Object[] arguments = new Object[3];
		arguments[0] = c.getIdUser();
		arguments[1] = c.getDate();
		arguments[2] = c.getId();
		jdbcTemplate.update("UPDATE command SET id_user=?, date=? WHERE id=?",arguments);
	}

	public void deleteCommand(int id) {
		jdbcTemplate.execute("DELETE from command where id ="+id);
		
	}
}
