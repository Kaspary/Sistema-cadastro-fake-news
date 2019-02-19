package com.ftec.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftec.spring.entity.User;
import com.ftec.spring.repository.UserRepository;
import com.ftec.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;	
	
	@Override
	public List<User> loadAll() {

		List<User> users = new ArrayList<>();
		
		repository.findAll().forEach(users::add);
		
		return users;
	}

	@Override
	public User load(int id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Registro não encontrado"));
	}

	@Override
	public void saveOrUpdate(User user) {
		repository.save(user);
	}

	@Override
	public void remove(User user) {
		repository.delete(user);
	}

	@Override
	public User testLogin(String email, String password) {
		
		User user = repository.findByEmail(email);
		
		if (user != null) {
			if(user.getPassword().equals(password)){
				return user;
			}
		}
		
		return null;
	}
	
}
