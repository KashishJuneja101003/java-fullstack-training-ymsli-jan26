package com.solid.pattern.isp.repo;

import java.util.List;

import com.solid.pattern.isp.entities.User;

public class UserRepo implements CrudRepository<User>{

	@Override
	public void save(User entity) {
		//make a sence
	}

	@Override
	public void delete(User entity) {
		//make a sence
	}

	@Override
	public User findById(Long id) {
		//make a sence
		return null;
	}

	@Override
	public List<User> findByName(String name) {
		 //make a sence
		return null;
	}

}
