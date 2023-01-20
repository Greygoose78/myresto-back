package com.myresto.dao;

import java.util.List;
import com.myresto.domaine.User;

public interface IUserDao {

	User getUserById(int id);
    List<User> getAllUsers();
	void createUser(User u);
	void updateUser(User u);
	void deleteUser(int id);
	User login(String login, String password);
}
