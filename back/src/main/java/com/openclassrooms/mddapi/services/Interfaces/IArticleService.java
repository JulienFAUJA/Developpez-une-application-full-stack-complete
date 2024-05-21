package com.openclassrooms.mddapi.services.Interfaces;

import com.openclassrooms.mddapi.dto.ArticleRequestDTO;
import com.openclassrooms.mddapi.dto.ArticleResponseDTO;

import java.util.List;

public interface IArticleService {
	

	ArticleResponseDTO postArticle(ArticleRequestDTO articleDTO, String userEmail);

	ArticleResponseDTO getArticleById(Integer id);

	List<ArticleResponseDTO> getAllArticlesForUser(String userEmail);
}
