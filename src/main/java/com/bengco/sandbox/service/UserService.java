package com.bengco.sandbox.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bengco.sandbox.model.User;

@Service
public interface UserService {

	List<User> getAllUsers();
	
	List<User> getAllUsers(Pageable pageable);

	User getUserById(Integer id);

	User getUserByUsername(String username);

	User getUserByFirstname(String firstname);

	User addUser(User user);

	User updateUser(User user);

	void deleteUser(Integer id) throws IllegalArgumentException;

}
