package com.calapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class CityApiTest {

	private CityApi api;
	@BeforeEach
	void setUp() throws Exception {
		api=new CityApi();
	}
	
	
	@Disabled
	@Test
	@Timeout(value = 1500, unit = TimeUnit.MILLISECONDS)
	void getCityTest() {
		Assertions.assertEquals("delhi", api.getCity(4343));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
	void toUpperCase_ShouldGenerateTheExpectedUppercaseValueCSVFile(
	  String input, String expected) {
	    String actualValue = input.toUpperCase();
	    assertEquals(expected, actualValue);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		api=null;
	}



}
