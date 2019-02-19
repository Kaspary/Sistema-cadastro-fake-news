package com.ftec.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ftec.spring.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	public User findByEmail(String Email);
	
}
