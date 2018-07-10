package com.bengco.sandbox.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bengco.sandbox.model.User;
import com.bengco.sandbox.repository.UserRepository;
import com.bengco.sandbox.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@TestConfiguration
	static class UserServiceImplTestContextConfiguration {

		@Bean
		public UserService userService() {
			return new UserServiceImpl();
		}
	}

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Before
	public void setUp() {
		User user = new User("service.test@yopmail.com", "john", "doe");

		// Use Mockito
		Mockito.when(userRepository.findByUsername(user.getUsername())).thenReturn(user);
	}

	@Test
	public void whenValidUsername_thenUserShouldBeFound() {
		String username = "service.test@yopmail.com";
		User found = userService.getUserByUsername(username);

		assertThat(found.getUsername()).isEqualTo(username);
	}
}
