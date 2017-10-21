package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void findAll() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/product"))
			.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
			.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
			.andReturn();

		String responseBody = result.getResponse().getContentAsString();
		log.info("findAll responseBody: {}", responseBody);
	}

	@Test
	public void calculateValueOfProducts() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/productValue"))
			.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
			.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
			.andReturn();

		String responseBody = result.getResponse().getContentAsString();
		log.info("calculateValueOfProducts responseBody: {}", responseBody);
	}

}
