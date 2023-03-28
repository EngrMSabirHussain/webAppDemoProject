package com.dropsourcing.repositiors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dropsourcing.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
