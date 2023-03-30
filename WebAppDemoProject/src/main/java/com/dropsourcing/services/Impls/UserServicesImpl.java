package com.dropsourcing.services.Impls;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dropsourcing.entities.User;
import com.dropsourcing.repositiors.UserRepo;
import com.dropsourcing.services.UserServices;


@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	UserRepo userRepo;

	@Override
	public User createUser(User user) {
		User saveUser=userRepo.save(user);
		return saveUser;
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user, int userId) {
		User getUser=this.userRepo.findById(userId).get();
		
		getUser.setFirstName(user.getFirstName());
		getUser.setLastName(user.getLastName());
		getUser.setEmail(user.getEmail());
		getUser.setId(user.getId());
		getUser.setPassword(user.getPassword());
		getUser.setRole(user.getRole());
		
		return getUser;
	}

	@Override
	public void delUserById(int UserId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delAllUsers() {
		userRepo.deleteAll();
		
	}

	
}
