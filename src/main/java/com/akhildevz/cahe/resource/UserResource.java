package com.akhildevz.cahe.resource;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akhildevz.cahe.model.User;
import com.akhildevz.cahe.repository.UserRepository;

@RestController
@RequestMapping("/rest/user")
public class UserResource {
	
	@Autowired
	private UserRepository userRepository;
	
	
	//save User
	@GetMapping("/add/{id}/{name}")
	public User add(@PathVariable("id") final String id,
					@PathVariable("name") final String name) {
		
		//save the user
		userRepository.save(new User(id, name, 20000L));
		
		//return the user
		return userRepository.findById(id);
	}
	
	//update User
	@GetMapping("/update/{id}/{name}")
	public User update(@PathVariable("id") final String id,
					@PathVariable("name") final String name) {
		
		//save the user
		userRepository.update(new User(id, name, 1000L));
		
		//return the user
		return userRepository.findById(id);
	}
	
	//get all
	@GetMapping("/all")
	public Map<String, User> getAll() {
		
		//return the user
		return userRepository.findAll();
	}
	
	//delete
	@GetMapping("/delete/{id}")
	public Map<String, User> delete(@PathVariable("id") final String id) {
	
		//delete the user
		userRepository.delete(id);
		
		//return the user
		return getAll();
	}
}
