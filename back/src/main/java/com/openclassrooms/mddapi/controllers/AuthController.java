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

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	


@Autowired
private IAuthService authService;
	

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
	


	@PostMapping(value ="/login", consumes={"application/json"})
    public ResponseEntity<?> login(@Valid @RequestBody(required = true) UserLoginDTO userLoginDTO) {
		String token = authService.authenticating(userLoginDTO);
		if (token == null) {
			String errorResponse= "Unauthorized: Erreur d'dentifiants...";
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
		}
		else {
			System.out.println("Token:"+token);
			return ResponseEntity.ok(new TokenDTO(token));
		} 
    }
	

	@GetMapping(value ="/profile")
	public ResponseEntity<?> getMe(Principal user) {
		return ResponseEntity.status(HttpStatus.OK).body(this.authService.me(user));
	}

	@PutMapping(value ="/update", consumes={"application/json"})
	public ResponseEntity<?> update(@Valid @RequestBody(required = true) UserUpdateDTO userUpdateDTO, Authentication authentication) {
		String userEmail = authentication.getName();
		return ResponseEntity.status(HttpStatus.OK).body(this.authService.update_user(userUpdateDTO, userEmail));

	}
}
