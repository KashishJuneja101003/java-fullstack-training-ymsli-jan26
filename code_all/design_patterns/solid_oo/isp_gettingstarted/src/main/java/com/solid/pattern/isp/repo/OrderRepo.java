package com.solid.pattern.isp.repo;

import java.util.List;

import com.solid.pattern.isp.entities.Order;


public class OrderRepo implements CrudRepository<Order>{

	@Override
	public void save(Order entity) {
		//make a sence
		
	}

	@Override
	public void delete(Order entity) {
		//make a sence
	}

	@Override
	public Order findById(Long id) {
		//make a sence
		return null;
	}

	@Override
	public List<Order> findByName(String name) {
		if(1==1)
		throw new RuntimeException();
		return null;
	}

}
