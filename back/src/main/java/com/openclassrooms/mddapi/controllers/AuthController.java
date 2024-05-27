package com.openclassrooms.mddapi.controllers;

import java.security.Principal;

import com.openclassrooms.mddapi.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.openclassrooms.mddapi.services.Interfaces.IAuthService;


import jakarta.validation.Valid;

/**
 * The type Auth controller.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	


@Autowired
private IAuthService authService;


	/**
	 * Post register method.
	 *
	 * @param userRegisterDTO the user register dto
	 * @return the token
	 */
	@PostMapping(value ="/register")
	@ResponseBody
	public ResponseEntity<?> postRegister(@Valid @RequestBody UserRegisterDTO userRegisterDTO) {
		TokenDTO token =  authService.register(userRegisterDTO);
		if (token == null) {
			String errorResponse= "Erreur dans le formulaire...";
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
		}
		else {
			return ResponseEntity.ok(token);
		}
	}


	/**
	 * Login response method.
	 *
	 * @param userLoginDTO the user login dto
	 * @return the token
	 */
	@PostMapping(value ="/login", consumes={"application/json"})
    public ResponseEntity<?> login(@Valid @RequestBody(required = true) UserLoginDTO userLoginDTO) {
		String token = authService.authenticating(userLoginDTO);
		if (token == null) {
			String errorResponse= "Unauthorized: Erreur d'dentifiants...";
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
		}
		else {
			return ResponseEntity.ok(new TokenDTO(token));
		} 
    }


	/**
	 * Gets profile page.
	 *
	 * @param user the user
	 * @return the user data
	 */
	@GetMapping(value ="/profile")
	public ResponseEntity<?> getMe(Principal user) {
		return ResponseEntity.status(HttpStatus.OK).body(this.authService.me(user));
	}

	/**
	 * Update response entity.
	 *
	 * @param userUpdateDTO  the user update dto
	 * @param authentication the authentication
	 * @return the response entity
	 */
	@PutMapping(value ="/update", consumes={"application/json"})
	public ResponseEntity<?> update(@Valid @RequestBody(required = true) UserUpdateDTO userUpdateDTO, Authentication authentication) {
		String userEmail = authentication.getName();
		return ResponseEntity.status(HttpStatus.OK).body(this.authService.update_user(userUpdateDTO, userEmail));

	}
}
