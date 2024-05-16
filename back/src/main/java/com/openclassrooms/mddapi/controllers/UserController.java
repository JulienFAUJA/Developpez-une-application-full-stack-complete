package com.openclassrooms.mddapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.dto.UserDTO;
import com.openclassrooms.mddapi.services.Interfaces.IUserService;



@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
    private IUserService userService;
	

	@GetMapping("{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
	}
}
