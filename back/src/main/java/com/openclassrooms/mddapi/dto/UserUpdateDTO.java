package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.models.UserModel;

import java.sql.Timestamp;


public class UserUpdateDTO {


	private String email;
	private String name;


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public UserUpdateDTO() {
	}


	public UserUpdateDTO(String email, String name) {
		this.email = email;
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserUpdateDTO [email=" + email + ", name=" + name + "]";
	}

}