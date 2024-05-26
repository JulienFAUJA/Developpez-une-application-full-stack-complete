package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.models.UserModel;

import java.sql.Timestamp;


public class UserUpdateDTO {


	private String email;
	private String name;


	private String password;


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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public UserUpdateDTO(String email, String name) {
		this.email = email;
		this.name = name;
	}

	public UserUpdateDTO(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserUpdateDTO [email=" + email + ", name=" + name + " ,password="+password+"]";
	}

}