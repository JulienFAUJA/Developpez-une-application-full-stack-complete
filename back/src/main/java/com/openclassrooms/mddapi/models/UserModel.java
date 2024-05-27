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


/**
 * The type User model.
 */
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


	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * Gets email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * Sets email.
	 *
	 * @param email the email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	/**
	 * Sets name.
	 *
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets password.
	 *
	 * @param password the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets created at.
	 *
	 * @return the created at
	 */
	public Timestamp getCreated_at() {
		return created_at;
	}

	/**
	 * Sets created at.
	 *
	 * @param created_at the created at
	 */
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}


	/**
	 * Instantiates a new User model.
	 */
	public UserModel() {
		
	}
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", created_at=" + created_at;
	}

	/**
	 * Instantiates a new User model.
	 *
	 * @param email    the email
	 * @param password the password
	 */
	public UserModel(String email, String password) {
		this.email = email;
		this.password = password;
	}

	/**
	 * Instantiates a new User model.
	 *
	 * @param email    the email
	 * @param name     the name
	 * @param password the password
	 */
	public UserModel(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	/**
	 * Instantiates a new User model.
	 *
	 * @param id         the id
	 * @param email      the email
	 * @param name       the name
	 * @param password   the password
	 * @param created_at the created at
	 */
	public UserModel(Integer id, String email, String name, String password, Timestamp created_at) {
		this.id=id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.created_at = created_at;
	}

}
