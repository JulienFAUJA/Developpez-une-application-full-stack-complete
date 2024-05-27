package com.openclassrooms.mddapi.dto;

import java.sql.Timestamp;
import java.time.Instant;

import com.openclassrooms.mddapi.models.UserModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * The type User register dto.
 */
public class UserRegisterDTO {
	
	private Integer id;
	
    @NotBlank(message="L'adresse email est obligatoire...")
    @Size(max=255, message = "L'adresse email est trop longue...")
    @Email(message = "Le format de l'adresse mail n'est pas valide...")
	private String email;
    
    @NotBlank(message="Le nom est obligatoire")
    @Size(max=255, message = "Le nom contient trop de caractères")
	private String name;
    
    @NotBlank(message="Le mot de passe est obligatoire...")
	private String password;
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

	/**
	 * Gets name.
	 *
	 * @return the name
	 */
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
	 * Sets created at now.
	 */
	public void setCreated_atNow() {
		Timestamp now = Timestamp.from(Instant.now());
		this.setCreated_at(now);
	}


	/**
	 * Instantiates a new User register dto.
	 */
	public UserRegisterDTO() {
	}


	/**
	 * Instantiates a new User register dto.
	 *
	 * @param email the email
	 * @param name  the name
	 */
	public UserRegisterDTO(String email, String name) {
		this.email = email;
		this.name = name;
	}

	/**
	 * Instantiates a new User register dto.
	 *
	 * @param email    the email
	 * @param name     the name
	 * @param password the password
	 */
	public UserRegisterDTO(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
		Timestamp now = Timestamp.from(Instant.now());
		this.created_at = now;
	}
	
	
	@Override
	public String toString() {
		return "UserRegisterDTO [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", created_at=" + created_at + "]";
	}

	/**
	 * Instantiates a new User register dto.
	 *
	 * @param id         the id
	 * @param email      the email
	 * @param name       the name
	 * @param password   the password
	 * @param created_at the created at
	 */
	public UserRegisterDTO(Integer id, String email, String name, String password, Timestamp created_at) {
		this.id=id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.created_at = created_at;
	}

}