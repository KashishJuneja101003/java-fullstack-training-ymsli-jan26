package com.productapp;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.productapp.dto.Product;
import com.productapp.service.ProductService;

import jakarta.persistence.EntityManagerFactory;

@EnableAspectJAutoProxy

@SpringBootApplication

@EnableTransactionManagement
public class Productappsbv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Productappsbv1Application.class, args);
	}

}

//@EnableAspectJAutoProxy
//@SpringBootApplication
//@EnableTransactionManagement
//public class Productappsbv1Application implements CommandLineRunner{
//
//	@Autowired
//	private DataSource dataSource;
//	
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	@Autowired
//	private EntityManagerFactory entityManagerFactory;
//	
//	
//	public static void main(String[] args) {
//		ConfigurableApplicationContext ctx = SpringApplication.run(Productappsbv1Application.class, args);
//		ProductService productService=(ProductService) ctx.getBean("ps");
//		List<Product> proList=productService.getAllProduct();
//		proList.forEach(p-> System.out.println(p));
//	
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		if(dataSource!=null) {
//			System.out.println("wow i need not conifgure it : sb rock!");
//		}
//		if(entityManagerFactory!=null) {
//			System.out.println("wow i need not conifgure entityManagerFactory : sb rock!");
//		}
//	}
//
//}
