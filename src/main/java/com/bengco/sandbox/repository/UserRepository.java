package com.bengco.sandbox.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.bengco.sandbox.model.User;

public interface UserRepository extends CrudRepository<User, Integer>, PagingAndSortingRepository<User, Integer> {
	
	/**
	 * Retrieves user by username
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
	
	/**
	 * Retrieves user by firstname
	 *
	 * @param firstname
	 * @return
	 */
	public User findByFirstname(String firstname);
	
}
