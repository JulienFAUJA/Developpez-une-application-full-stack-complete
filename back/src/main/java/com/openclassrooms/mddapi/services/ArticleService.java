package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.CommentaireResponseDTO;
import com.openclassrooms.mddapi.models.CommentaireModel;
import com.openclassrooms.mddapi.models.ThemeModel;
import com.openclassrooms.mddapi.models.UserModel;
import com.openclassrooms.mddapi.repositories.CommentaireRepository;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import com.openclassrooms.mddapi.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.dto.ArticleRequestDTO;
import com.openclassrooms.mddapi.dto.ArticleResponseDTO;
import com.openclassrooms.mddapi.models.ArticleModel;
import com.openclassrooms.mddapi.repositories.ArticleRepository;
import com.openclassrooms.mddapi.services.Interfaces.IArticleService;

import java.util.List;


@Service
public class ArticleService implements IArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private CommentaireRepository commentaireRepository;

	@Autowired
	private ThemeRepository themeRepository;

	@Autowired
	private UserRepository userRepository;

	
	@Autowired
	private ModelMapper modelMapper;



	public ArticleResponseDTO getArticleById(Integer id) {
		// Récup de l'article
		ArticleModel articleModel = this.articleRepository.findById(id).orElseThrow();
		System.out.println("Article fetched:"+articleModel.toString());
		if(articleModel != null){
			Integer article_id=articleModel.getId();
			System.out.println("article_id:"+article_id.toString());
			// Récupérer les commentaires de cet article puisque c'est pour article/détail
			List<CommentaireModel> commentaireModel = this.commentaireRepository.findAllByArticleId(article_id);
			System.out.println("Commentaires fetched:"+commentaireModel.toString());
			ArticleResponseDTO article_dto = modelMapper.map(articleModel, ArticleResponseDTO.class);
			CommentaireResponseDTO commentaires_dto = modelMapper.map(commentaireModel, CommentaireResponseDTO.class);

			UserModel userModel = this.userRepository.findById(articleModel.getAuteur_id()).orElseThrow();
			if (userModel != null){
				String user_str = userModel.getName();
				//commentaires_dto.setUser_str(user_str);
			}

			article_dto.setCommentaires((List<CommentaireResponseDTO>) commentaires_dto);
			return article_dto;
		}
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


	public ArticleResponseDTO postArticle(ArticleRequestDTO articleRequestDTO, String userEmail) {
		UserModel user = userRepository.findByEmail(userEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with email"));
    	if (
				articleRequestDTO.getContenu() == null ||
				articleRequestDTO.getTitre() == null) {
    		ArticleResponseDTO errorResponse = new ArticleResponseDTO();
	        return errorResponse;
    	}
		ArticleModel articleCreated = modelMapper.map(articleRequestDTO, ArticleModel.class);
		articleCreated.setCreated_atNow();
		String theme_name = articleRequestDTO.getTheme();
		ThemeModel theme = themeRepository.findByTheme(theme_name);
		Integer theme_id = theme.getId();
		articleCreated.setTheme_id(theme_id);
		articleCreated.setAuteur_id(user.getId());
		System.out.println("Article Mapped :"+articleCreated.toString());
		try {
			ArticleModel articleModelSaved = articleRepository.save(articleCreated);
			System.out.println("Article Saved:"+articleModelSaved.toString());
			ArticleResponseDTO articleResponse = modelMapper.map(articleModelSaved, ArticleResponseDTO.class);
	    	return articleResponse;
		}
		catch (AuthenticationException e) {
	        // Si une exception d'authentification se produit (par exemple, erreur 401)
	    	ArticleResponseDTO errorResponse = new ArticleResponseDTO();
	        return errorResponse;
	    }
		
    }



}
