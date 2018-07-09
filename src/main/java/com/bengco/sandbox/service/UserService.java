package com.bengco.sandbox.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bengco.sandbox.model.User;
import com.bengco.sandbox.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 
	 * @return
	 */
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void deleteUser(Integer id) throws IllegalArgumentException{
		userRepository.delete(id);
	}

}
