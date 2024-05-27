package com.openclassrooms.mddapi.services.Interfaces;

import com.openclassrooms.mddapi.dto.ArticleRequestDTO;
import com.openclassrooms.mddapi.dto.ArticleResponseDTO;

import java.util.List;

/**
 * The interface Article service.
 */
public interface IArticleService {


	/**
	 * Post article article response dto.
	 *
	 * @param articleDTO the article dto
	 * @param userEmail  the user email
	 * @return the article response dto
	 */
	ArticleResponseDTO postArticle(ArticleRequestDTO articleDTO, String userEmail);

	/**
	 * Gets article by id.
	 *
	 * @param id the id
	 * @return the article by id
	 */
	ArticleResponseDTO getArticleById(Integer id);

	/**
	 * Gets all articles for user.
	 *
	 * @param userEmail the user email
	 * @return the all articles for user
	 */
	List<ArticleResponseDTO> getAllArticlesForUser(String userEmail);
}
