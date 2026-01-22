package com.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//this object is corropstanc to table

public class ProductDto {
	
	private String name;
	private double price;
	public ProductDto(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductDto [name=" + name + ", price=" + price + "]";
	}
	
	
	
	

}