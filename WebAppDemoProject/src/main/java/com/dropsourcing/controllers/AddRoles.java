package com.dropsourcing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dropsourcing.entities.Role;
import com.dropsourcing.repositiors.RoleRepo;

@RestController
public class AddRoles {
	
	@Autowired
	RoleRepo roleRepo;
	
	@PostMapping("/addRole")
	public Role createNewRole(@RequestBody Role role) {
		roleRepo.save(role);
		return role;
	}

	@PutMapping("/addRole/{id}")
	public Role updateRole(@RequestBody Role role,@PathVariable int id) {
		Role getRole=roleRepo.findById(id).get();
		
		getRole.setId(role.getId());
		getRole.setName(role.getName());
		
		roleRepo.save(getRole);
		return getRole;
	}
}
