package com.myresto.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.myresto.domaine.User;

@Repository
public class UserDao implements IUserDao{

	private JdbcTemplate jdbcTemplate;

	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	//Read
	public User getUserById(int id){
		Object[] arguments = new Object[1];
		arguments[0]= id;
		return jdbcTemplate.queryForObject("Select * from myresto.user where user.id="+id,(resultSet, rowNum) -> {
			return new User(resultSet.getInt("id"),resultSet.getString("mail"), resultSet.getString("password"),resultSet.getString("username"),resultSet.getString("address"),resultSet.getString("phone"),resultSet.getBoolean("manager"));
		});
	}
	
	//Read
	public List<User> getAllUsers(){
		return jdbcTemplate.query("Select * from myresto.user",(resultSet, rowNum) -> {
			return new User(resultSet.getInt("id"),resultSet.getString("mail"), resultSet.getString("password"),resultSet.getString("username"),resultSet.getString("address"),resultSet.getString("phone"),resultSet.getBoolean("manager"));
		});
	}

	//Create
	public void createUser(User u) {
		Object[] arguments = new Object[6];
		arguments[0] = u.getMail();
		arguments[1] = u.getPassword();
		arguments[2] = u.getUsername();
		arguments[3] = u.getAddress();
		arguments[4] = u.getPhone();
		arguments[5] = u.isManager();		
		jdbcTemplate.update("INSERT INTO myresto.user(mail,password,username,address,phone,manager) VALUES(?,?,?,?,?,?)",arguments);
	}
	
	//Update
	public void updateUser(User u) {
		Object[] arguments = new Object[6];
		arguments[0] = u.getMail();
		arguments[1] = u.getPassword();
		arguments[2] = u.getUsername();
		arguments[3] = u.getAddress();
		arguments[4] = u.getPhone();
		arguments[5] = u.isManager();
		jdbcTemplate.update("UPDATE myresto.user SET mail=?, password=?, username=?, address=?, phone=?, manager=? where user.id="+u.getId(),arguments);
	}

	//Delete
	public void deleteUser(int id) {
		jdbcTemplate.execute("DELETE FROM myresto.user where user.id ="+id);
	}

	//Login
	public User login(String login, String password) {
		return jdbcTemplate.queryForObject("Select id,mail,username,address,phone,manager from user where username='"+login+"' and password=PASSWORD('"+password+"')",(resultSet, rowNum) -> {
			return new User(resultSet.getInt("id"),resultSet.getString("mail"),resultSet.getString("username"),resultSet.getString("address"),resultSet.getString("phone"),resultSet.getBoolean("manager"));
		});
	}
	
}
