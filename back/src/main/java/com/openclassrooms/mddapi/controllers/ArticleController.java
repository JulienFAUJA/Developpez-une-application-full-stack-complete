package com.openclassrooms.mddapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.mddapi.dto.ArticleRequestDTO;
import com.openclassrooms.mddapi.dto.ArticleResponseDTO;
import com.openclassrooms.mddapi.services.Interfaces.IArticleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/messages")
public class ArticleController {
	
	@Autowired
    private IArticleService messageService;

	
	@PostMapping 
	@ResponseBody
	public ResponseEntity<?> postMessage(@Valid @RequestBody ArticleRequestDTO articleRequestDTO) {
		ArticleResponseDTO articleResponseDTO = articleService.postArticle(articleRequestDTO);
		if (articleResponseDTO.getContenu() == "Bad request: ") {
			
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(articleResponseDTO);
		}
		else if (articleResponseDTO.getContenu() == "Unauthorized: ") {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(articleResponseDTO);
		}
		else {
			return ResponseEntity.ok(articleResponseDTO);
		}
		 
	}
	
		
}
