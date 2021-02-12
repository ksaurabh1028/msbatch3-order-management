package com.sl.ms.ordermanagement;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class WebServicesTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnAllOrders() throws Exception {
		this.mockMvc.perform(get("/orders")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Order1")));

	}

	@Test
	public void shouldReturnGivenOrder() throws Exception {
		this.mockMvc.perform(get("/orders/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Order1")));
	}

	@Test
	public void shouldAddNewOrder() throws Exception {
		Item item = new Item((long) 5, "Item4", 3, 34.2, 123.50);
		Set<Item> items = new HashSet<>();
		items.add(item);
		Order newOrder = new Order((long) 3, "Order3", 23.50, items);

		this.mockMvc.perform(post("/orders/3").contentType("application/json").content(asJsonString(newOrder)))
				.andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void shouldDeleteGivenOrder() throws Exception {
		this.mockMvc.perform(get("/orders/2")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Order2")));
	}

}