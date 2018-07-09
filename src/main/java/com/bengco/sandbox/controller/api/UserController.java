package com.bengco.sandbox.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bengco.sandbox.model.User;
import com.bengco.sandbox.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET, value="/users")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public User updateUser(@RequestParam Integer id, @RequestBody User user) {
		user.setId(id);
		return userService.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public String deleteUser(@RequestParam Integer id) {
		userService.deleteUser(id);
		StringBuilder response = new StringBuilder();
		response.append("User with id of ");
		response.append(id);
		response.append(" was deleted");
		return response.toString(); 
	}
}
