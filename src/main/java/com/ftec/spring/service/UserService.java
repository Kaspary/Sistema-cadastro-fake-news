package com.ftec.spring.service;

import java.util.List;

import com.ftec.spring.entity.User;

public interface UserService {

	public List<User> loadAll();
	
	public User load(int id);
	
	public void saveOrUpdate(User user);
		
	public void remove(User user);
	
	public User testLogin(String email, String password);
}
