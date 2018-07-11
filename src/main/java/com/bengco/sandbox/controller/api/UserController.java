package com.bengco.sandbox.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

	/**
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, params = {"page", "size"},  value = "/users")
	public List<User> getUsers(@RequestParam int page, @RequestParam int size) {
		return userService.getAllUsers(page, size);
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "users/{id}")
	public User getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "users/firstname/{firstname}")
	public User getUserById(@PathVariable String firstname) {
		return userService.getUserByFirstname(firstname);
	}

	/**
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/users/username/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

	/**
	 * 
	 * @param id
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public User updateUser(@PathVariable Integer id, @RequestBody User user) {
		user.setId(id);
		return userService.updateUser(user);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public String deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		StringBuilder response = new StringBuilder();
		response.append("User with id of ");
		response.append(id);
		response.append(" was deleted");
		return response.toString();
	}
}
