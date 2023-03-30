package com.dropsourcing.playloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
}
