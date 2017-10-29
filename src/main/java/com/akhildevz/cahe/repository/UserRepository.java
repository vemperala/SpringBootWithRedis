package com.akhildevz.cahe.repository;


import java.util.List;
import java.util.Map;

import com.akhildevz.cahe.model.User;

public interface UserRepository {
	
	void save(User user); 
	
	Map<String, User> findAll();
	
	User findById(String id);
	
	void update(User user);
	
	void delete(String id);
}
