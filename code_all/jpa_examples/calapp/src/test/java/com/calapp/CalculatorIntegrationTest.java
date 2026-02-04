package com.calapp;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	 @Test
	    void divide_shouldReturnResult_whenValidInputs() throws Exception {

	        mockMvc.perform(get("/calculator/divide")
	                .param("a", "20")
	                .param("b", "4"))
	                .andExpect(status().isOk())
	                .andExpect(content().string("5"));
	    }

	    @Test
	    void divide_shouldReturnBadRequest_whenDivideByZero() throws Exception {

	        mockMvc.perform(get("/calculator/divide")
	                .param("a", "10")
	                .param("b", "0"))
	                .andExpect(status().isBadRequest())
	                .andExpect(content().string("Division by zero is not allowed"));
	    }
}
