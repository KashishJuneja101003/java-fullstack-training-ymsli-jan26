package com.productapp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@SpringBootApplication
@Import(DbConfig.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.productapp"})
public class Productappv1Application implements CommandLineRunner {
	
	@Autowired
	private DataSource dataSource;
	
//	@Autowired
//	private EntityManagerFactory emf;
//	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Productappv1Application.class, args);
//		String beansNames[]=ctx.getBeanDefinitionNames();
//		for(String name: beansNames) {
//			System.out.println(name);
//		}
	}

	@Override
	public void run(String... args) throws Exception {
//		if(jdbcTemplate!=null) {
//			System.out.println("wow it is jdbcTemplate working!");
//		}
		
		if(dataSource!=null) {
			System.out.println("wow it is ds working!");
		}
//		if(emf!=null) {
//			System.out.println("wow it is emf working!");
//		}
		
		System.out.println("--------------------");
	}

}
