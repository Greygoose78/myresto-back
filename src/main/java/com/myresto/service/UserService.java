package com.myresto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myresto.dao.IUserDao;
import com.myresto.domaine.User;

@Service("UserService")
public class UserService {
	
	@Autowired
	private IUserDao iUserDao;
	
	public UserService() {
	}

	public UserService(IUserDao iUserDao) {
		super();
		this.iUserDao = iUserDao;
	}
	
	public List<User> getAllUsers(){
		return iUserDao.getAllUsers();
	}

	public User getUserById(int id){
		return iUserDao.getUserById(id);
	}
	
	public void createUser(User p) {
		iUserDao.createUser(p);
	}
	public void updateUser(User p) {
		iUserDao.updateUser(p);
	}
    public void deleteUser(int id) {
		iUserDao.deleteUser(id);
	}

    public User login(String login, String password) {
        return iUserDao.login(login, password);
    }
	

}