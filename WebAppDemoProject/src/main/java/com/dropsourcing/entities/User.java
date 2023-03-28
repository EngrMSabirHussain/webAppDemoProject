package com.dropsourcing.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_table")

@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(name = "first_Name", nullable = false, length = 20 )
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_email")
	private String email;
	
	
	@Column(name="user_password")
	private String password;
}
