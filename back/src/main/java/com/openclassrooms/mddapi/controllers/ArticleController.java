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

/**
 * Controlleur pour la gestion des articles
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {
	
	@Autowired
    private IArticleService articleService;


	/**
	 * Post article response entity.
	 *
	 * @param articleRequestDTO the article request dto
	 * @param authentication    the authentication
	 * @return the response entity
	 */
	@ResponseBody
	@PostMapping("/create")

	public ResponseEntity<?> postArticle(@Valid @RequestBody ArticleRequestDTO articleRequestDTO, Authentication authentication) {
		String userEmail = authentication.getName();
		System.out.println("articleRequestDTO:"+articleRequestDTO.toString()+"email:"+userEmail);
		ArticleResponseDTO articleResponseDTO = articleService.postArticle(articleRequestDTO, userEmail);
		if (articleResponseDTO==null) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(articleResponseDTO);
		}
		else {
			return ResponseEntity.ok(articleResponseDTO);
		}
	}

	/**
	 * Gets all articles for the logged user.
	 *
	 * @param authentication the authentication
	 * @return the all articles for the logged user
	 */
	@GetMapping("/all")
	public ResponseEntity<?> getAllArticlesForUser(Authentication authentication) {
		String userEmail = authentication.getName();
		return ResponseEntity.status(HttpStatus.OK).body(articleService.getAllArticlesForUser(userEmail));
	}

	/**
	 * Gets article by id.
	 *
	 * @param id the id
	 * @return the article by id
	 */
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> getArticleById(@PathVariable("id") Integer id) {
		System.out.println(LocationHelpers.ARTICLES_URI);
		return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticleById(id));
	}
	
		
}
