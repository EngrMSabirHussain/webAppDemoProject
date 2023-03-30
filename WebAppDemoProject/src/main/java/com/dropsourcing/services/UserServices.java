package com.dropsourcing.services;

import java.util.List;

import com.dropsourcing.entities.User;

public interface UserServices {

	User createUser(User user);
	User getUserById(int userId);
	List<User> getAllUsers();
	
	User updateUser(User user, int userId);
	
	void delUserById(int UserId);
	void delAllUsers();
	
}
