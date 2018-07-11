package com.bengco.sandbox.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bengco.sandbox.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	private User user = new User(0, "jaydoe", "jay", "bengco");

	@Before
	public void addUser() {
		// Save user		
		userRepository.save(user);		
	}
	
	@Test
	public void whenFindByUsername_thenReturnUser() {

		User found = userRepository.findByUsername(user.getUsername());

		// check if user is same as last found
		assertThat(found.getUsername()).isEqualTo(user.getUsername());

	}

	@Test
	public void whenFindIdByUsername_thenReturnId() {
		// Save user
		List<Integer> ids = userRepository.getIdByUsername(user.getUsername());

		// is not empty
		assertThat(ids).isNotNull();
		assertThat(ids.size()).isGreaterThan(0);

	}

}
