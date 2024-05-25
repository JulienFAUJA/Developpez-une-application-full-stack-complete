package com.openclassrooms.mddapi.models;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "USERS")
public class UserModel implements Principal{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true)
	private String email;
	private String name;
	private String password;
	@CreationTimestamp
	private Timestamp  created_at;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	
	public UserModel() {
		
	}
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", created_at=" + created_at;
	}

	public UserModel(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public UserModel(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}
	public UserModel(Integer id, String email, String name, String password, Timestamp created_at) {
		this.id=id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.created_at = created_at;
	}

}
