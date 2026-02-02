package com.solid.pattern.isp.repo;

import java.util.List;

import com.solid.pattern.isp.entities.Entity;
//SOL ISP D
//common interface to be implemented by all persistence services. 
public interface CrudRepository<T extends Entity> {

	public void save(T entity);
	
	public void delete(T entity);
	
	public T findById(Long id);
	
	public List<T> findByName(String name) ;
	
}
