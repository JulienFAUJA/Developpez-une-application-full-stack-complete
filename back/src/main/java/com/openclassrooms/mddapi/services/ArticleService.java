package com.openclassrooms.mddapi.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.dto.ArticleRequestDTO;
import com.openclassrooms.mddapi.dto.ArticleResponseDTO;
import com.openclassrooms.mddapi.models.ArticleModel;
import com.openclassrooms.mddapi.repositories.ArticleRepository;
import com.openclassrooms.mddapi.services.Interfaces.IArticleService;


@Service
public class ArticleService implements IArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;



	public ArticleResponseDTO getArticleById(Integer id) {

		// Récupérer les commentaires de cet article puisque c'est pour article/détail
		return null;
	}

	@Override
	public ArticleResponseDTO[] getArticlesByThemeId(Integer id) {
		return null;
	}

	@Override
	public ArticleResponseDTO[] getAllArticlesForUser() {
		// Récup l'id de l'utilisateur connecté

		// Récup tous les theme_id des abonnements de l'utilisateur connecté

		// Récup tous les articles qui ont ces theme_id




		return new ArticleResponseDTO[0];
	}


	public ArticleResponseDTO postArticle(ArticleRequestDTO articleRequestDTO) {
    	if (
				articleRequestDTO.getContenu() == null ||
				articleRequestDTO.getTheme() == null ||
				articleRequestDTO.getTitre() == null) {
    		ArticleResponseDTO errorResponse = new ArticleResponseDTO("Bad request: ");
	        return errorResponse;
    	}
		ArticleModel articleCreated = modelMapper.map(articleRequestDTO, ArticleModel.class);


		articleCreated.setCreated_atNow();
		try {
			articleRepository.save(articleCreated);
			ArticleResponseDTO articleResponse = new ArticleResponseDTO("Message créé avec succès...");
	    	return articleResponse;
		}
		catch (AuthenticationException e) {
	        // Si une exception d'authentification se produit (par exemple, erreur 401)
	    	ArticleResponseDTO errorResponse = new ArticleResponseDTO("Unauthorized: ");
	        return errorResponse;
	    }
		
    }



}
