package com.myresto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myresto.domaine.User;
import com.myresto.service.UserService;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
	private UserService UserService; 

	@GetMapping("/users")
	public List<User> get(){
		return UserService.getAllUsers();
	}

	@GetMapping("/user/{id}")
	public User getuserById(@PathVariable("id") int id){
		return UserService.getUserById(id);
	}

	@PostMapping("/user/create")
	public void createuser(@RequestBody User p) {
		UserService.createUser(p);
	}
		
	@PutMapping("/user/update")
	public void update(@RequestBody User p) {
		UserService.updateUser(p);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		UserService.deleteUser(id);
	}
	
	@PostMapping("/user/login")
	public User login(@RequestBody User u) throws Exception {
		return UserService.login(u.getMail(), u.getPassword());
	}
}
