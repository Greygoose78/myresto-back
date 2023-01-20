package com.myresto.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myresto.domaine.Command;
import com.myresto.service.CommandService;


@CrossOrigin
@RestController
public class CommandController {


	@Autowired
	private CommandService Commandservice;

	@GetMapping("/commands")
	public List<Command> get() {
		return Commandservice.getAllCommands();
	}
	
	@GetMapping("/command/{id}")
	public Command get(@PathVariable("id")int id) {
		return Commandservice.getCommandById(id);
	}

	@PostMapping("/command/create")
	public void createCommand(@RequestBody Command command) {
		Commandservice.createCommand(command);
	}

	@PutMapping("/command/update")
	public void updateCommande(@RequestBody Command command) {
		Commandservice.updateCommand(command);
	}

	@DeleteMapping("/command/delete/{id}")
	public void delete(@PathVariable("id")int id) {
		Commandservice.deleteCommand(id);
	}

}
