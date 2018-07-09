package com.bengco.sandbox.repository;

import org.springframework.data.repository.CrudRepository;

import com.bengco.sandbox.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
