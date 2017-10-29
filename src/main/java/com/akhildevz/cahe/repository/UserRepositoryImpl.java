package com.akhildevz.cahe.repository;

import java.util.List;
import java.util.Map;

import org.apache.hadoop.mapred.gethistory_jsp;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.akhildevz.cahe.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private RedisTemplate<String, User> redisTemplate;
	
	private HashOperations hashOperations;
	
	
	
	public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
		
		this.redisTemplate = redisTemplate;
		this.hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(User user) {
		
		hashOperations.put("USER", user.getId(), user);
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, User> findAll() {
		// TODO Auto-generated method stub
		return hashOperations.entries("USER");
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return (User)hashOperations.get("USER", id);
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		save(user);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		hashOperations.delete("USER", id);
	}

}
