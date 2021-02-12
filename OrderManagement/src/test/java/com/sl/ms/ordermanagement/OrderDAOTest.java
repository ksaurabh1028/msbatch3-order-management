package com.sl.ms.ordermanagement;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderDAOTests {

	@Autowired
	private OrderDAO orderdao;
	
	@Test
	void contextLoads() {
		assertThat(orderdao).isNotNull();
	}

}
