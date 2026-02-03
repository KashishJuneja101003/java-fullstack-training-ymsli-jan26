package com.example.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.filter.F1Filter;
import com.example.filter.F2Filter;

@Configuration
public class FilterConfig {

	@Bean
	FilterRegistrationBean<F1Filter> f1Filter() {
		FilterRegistrationBean<F1Filter> registration = 
				new FilterRegistrationBean<>();
		
		registration.setFilter(new F1Filter());
		registration.addUrlPatterns("/*");
		registration.setOrder(1); // ✅ Lower = Higher Priority
		return registration;
	}

	@Bean
	FilterRegistrationBean<F2Filter> f2Filter() {
		FilterRegistrationBean<F2Filter> registration = new FilterRegistrationBean<>();
		registration.setFilter(new F2Filter());
		registration.addUrlPatterns("/*");
		registration.setOrder(2);
		return registration;
	}
}
