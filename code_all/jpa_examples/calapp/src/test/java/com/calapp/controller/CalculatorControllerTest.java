package com.calapp.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.calapp.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private CalculatorService service;
    
    @Test
    void divide_shouldReturnResult_whenValid() throws Exception {
        Mockito.when(service.divide(10, 2)).thenReturn(5);

        mockMvc.perform(get("/calculator/divide")
                .param("a", "10")
                .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }
    
    @Test
    void divide_shouldReturnBadRequest_whenDivideByZero() throws Exception {
        Mockito.when(service.divide(10, 0))
                .thenThrow(new ArithmeticException("Division by zero"));

        mockMvc.perform(get("/calculator/divide")
                .param("a", "10")
                .param("b", "0"))
                .andExpect(status().isBadRequest());
    }
}


















