package com.dropsourcing.repositiors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dropsourcing.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
