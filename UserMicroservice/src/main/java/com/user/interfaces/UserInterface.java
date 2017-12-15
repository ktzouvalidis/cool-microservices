package com.user.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.user.data.User;

public interface UserInterface extends CrudRepository<User, Integer> {
	
	public List<User> findByEmailAndPassword(String email, String password);

}
