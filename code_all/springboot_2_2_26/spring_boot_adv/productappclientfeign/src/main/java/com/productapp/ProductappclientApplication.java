package com.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients("com.productapp.serviceproxy")
@SpringBootApplication
public class ProductappclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductappclientApplication.class, args);
	}
	
}
