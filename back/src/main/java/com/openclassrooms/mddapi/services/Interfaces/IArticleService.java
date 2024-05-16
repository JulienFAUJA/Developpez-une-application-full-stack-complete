package com.openclassrooms.mddapi.services.Interfaces;

import com.openclassrooms.mddapi.dto.ArticleRequestDTO;
import com.openclassrooms.mddapi.dto.ArticleResponseDTO;

public interface IArticleService {
	
	ArticleResponseDTO postMessage(ArticleRequestDTO articleDTO);

}
