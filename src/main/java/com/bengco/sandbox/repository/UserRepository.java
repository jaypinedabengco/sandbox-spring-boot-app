package com.bengco.sandbox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

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
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	@Query(value="SELECT id FROM User WHERE username = :username")
	public List<Integer> getIdByUsername(@Param("username") String username);
}
