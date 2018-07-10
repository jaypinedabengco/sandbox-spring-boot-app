package com.bengco.sandbox.repository;

import static org.assertj.core.api.Assertions.assertThat;

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

	@Test
	public void whenFindByUsername_thenReturnUser() {

		// Save user
		User user = new User(0, "jaydoe", "jay", "bengco");
		userRepository.save(user);

		User userByUsername = userRepository.findByUsername(user.getUsername());

		// check if user is same as last found
		assertThat(userByUsername.getUsername()).isEqualTo(user.getUsername());

	}

}
