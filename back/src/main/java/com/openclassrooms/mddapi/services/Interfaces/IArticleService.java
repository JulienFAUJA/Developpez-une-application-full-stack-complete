package com.openclassrooms.mddapi.services.Interfaces;

import com.openclassrooms.mddapi.dto.ArticleRequestDTO;
import com.openclassrooms.mddapi.dto.ArticleResponseDTO;

public interface IArticleService {
	

	ArticleResponseDTO postArticle(ArticleRequestDTO articleDTO, String userEmail);

	ArticleResponseDTO getArticleById(Integer id);

	ArticleResponseDTO[] getArticlesByThemeId(Integer id);

	ArticleResponseDTO[] getAllArticlesForUser();
}
