package com.bengco.sandbox.controller.api;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bengco.sandbox.model.User;
import com.bengco.sandbox.util.JSONUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class UserControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;


	@Test
	public void givenEmployees_whenGetEmployees_thenStatus200() throws Exception {

		
		User user = new User("controller.test@yopmail.com", "John", "Doe");
		
		String userJSON = JSONUtil.convertToJSON(user);
		
//		// Save User First
		mvc.perform(post("/api/users")
				.contentType(MediaType.APPLICATION_JSON)
				.content(userJSON)
				).andExpect(status().isOk());
		
		// Get First User
		mvc.perform(get("/api/users")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1))).andExpect(jsonPath("$[0].username", is(user.getUsername())));
	}

}
