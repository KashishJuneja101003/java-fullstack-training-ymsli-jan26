package com.demo;

import org.hibernate.tuple.entity.EntityMetamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_t1")
public class Product{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "product_name", nullable = false)
	private String name;
	
	@Column(name = "product_price", nullable = false)
	private double price;
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
}