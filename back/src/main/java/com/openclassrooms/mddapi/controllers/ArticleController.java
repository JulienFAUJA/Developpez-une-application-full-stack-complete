package com.openclassrooms.mddapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	
	@PostMapping 
	@ResponseBody
	public ResponseEntity<?> postArticle(@Valid @RequestBody ArticleRequestDTO articleRequestDTO) {
		ArticleResponseDTO articleResponseDTO = articleService.postArticle(articleRequestDTO);
		if (articleResponseDTO.getMessage() == "Bad request: ") {
			
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(articleResponseDTO);
		}
		else if (articleResponseDTO.getMessage() == "Unauthorized: ") {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(articleResponseDTO);
		}
		else {
			return ResponseEntity.ok(articleResponseDTO);
		}
		 
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getArticleById(@PathVariable("id") Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticleById(id));
	}
	
		
}
