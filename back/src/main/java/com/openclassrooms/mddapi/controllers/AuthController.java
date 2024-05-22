package com.openclassrooms.mddapi.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.dto.ArticleResponseDTO;
import com.openclassrooms.mddapi.dto.TokenDTO;
import com.openclassrooms.mddapi.dto.UserLoginDTO;
import com.openclassrooms.mddapi.dto.UserRegisterDTO;

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
			//ArticleResponseDTO errorResponse = new ArticleResponseDTO("Unauthorized: ");
			String errorResponse= "Erreur dans le token...";
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
		}
		else {
			return ResponseEntity.ok(token);
		}
	}
	


	@PostMapping(value ="/login", consumes={"application/json"})
    public ResponseEntity<?> login(@Valid @RequestBody(required = true) UserLoginDTO userLoginDTO) {
		System.out.println("UserLoginDTO"+userLoginDTO.toString());
		TokenDTO token = authService.authenticating(userLoginDTO);
		if (token == null) {
			//ArticleResponseDTO errorResponse = new ArticleResponseDTO("Unauthorized: ");
			String errorResponse= "Erreur dans le token...";
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
		}
		else {
			return ResponseEntity.ok(token);
		} 
    }
	

	@GetMapping(value ="/me")
	public ResponseEntity<?> getMe(Principal user) {
		return ResponseEntity.status(HttpStatus.OK).body(this.authService.me(user));
		
	}
	
	
	

}
