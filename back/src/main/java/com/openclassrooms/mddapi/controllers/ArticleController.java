package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.configuration.LocationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.openclassrooms.mddapi.dto.ArticleRequestDTO;
import com.openclassrooms.mddapi.dto.ArticleResponseDTO;
import com.openclassrooms.mddapi.services.Interfaces.IArticleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
	
	@Autowired
    private IArticleService articleService;

	
	@ResponseBody
	@PostMapping("/create")
	public ResponseEntity<?> postArticle(@Valid @RequestBody ArticleRequestDTO articleRequestDTO, Authentication authentication) {
		String userEmail = authentication.getName();
		System.out.println("articleRequestDTO:"+articleRequestDTO.toString()+"email:"+userEmail);
		ArticleResponseDTO articleResponseDTO = articleService.postArticle(articleRequestDTO, userEmail);
		if (articleResponseDTO==null) {
			
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(articleResponseDTO);
		}
		/*
		else if (articleResponseDTO.getAuteur().isEmpty()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(articleResponseDTO);
		}
		*/

		else {
			return ResponseEntity.ok(articleResponseDTO);
		}
		 
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllArticlesForUser(Authentication authentication) {
		String userEmail = authentication.getName();
		return ResponseEntity.status(HttpStatus.OK).body(articleService.getAllArticlesForUser(userEmail));
	}

	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getArticleById(@PathVariable("id") Integer id) {
		System.out.println(LocationHelpers.ARTICLES_URI);
		return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticleById(id));
	}
	
		
}
