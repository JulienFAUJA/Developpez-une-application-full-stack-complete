package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.CommentaireResponseDTO;
import com.openclassrooms.mddapi.dto.ThemeResponseDTO;
import com.openclassrooms.mddapi.models.*;
import com.openclassrooms.mddapi.repositories.CommentaireRepository;
import com.openclassrooms.mddapi.repositories.ThemeRepository;
import com.openclassrooms.mddapi.repositories.UserRepository;
import com.openclassrooms.mddapi.repositories.AbonnementRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.dto.ArticleRequestDTO;
import com.openclassrooms.mddapi.dto.ArticleResponseDTO;
import com.openclassrooms.mddapi.repositories.ArticleRepository;
import com.openclassrooms.mddapi.services.Interfaces.IArticleService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ArticleService implements IArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private CommentaireRepository commentaireRepository;

	@Autowired
	private ThemeRepository themeRepository;

	@Autowired
	private AbonnementRepository abonnementRepository;

	@Autowired
	private UserRepository userRepository;

	
	@Autowired
	private ModelMapper modelMapper;



	public ArticleResponseDTO getArticleById(Integer id) {
		// Récup de l'article
		ArticleModel articleModel = this.articleRepository.findById(id).orElseThrow();
		System.out.println("Article fetched:" + articleModel.toString());

		if (articleModel != null) {
			Integer article_id = articleModel.getId();

			System.out.println("article_id:" + article_id.toString());

			// Récupérer les commentaires de cet article
			List<CommentaireModel> commentaireModels = this.commentaireRepository.findAllByArticleId(article_id);
			System.out.println("Commentaires fetched:" + commentaireModels.toString());

			// Récupérer le thème
			Optional<ThemeModel> themeModel = themeRepository.findById(articleModel.getThemeId());

			// Mapper ArticleModel à ArticleResponseDTO
			ArticleResponseDTO article_dto = modelMapper.map(articleModel, ArticleResponseDTO.class);
			if(themeModel.isPresent()){
				ThemeResponseDTO themeResponseDTO = modelMapper.map(themeModel, ThemeResponseDTO.class);
				article_dto.setTheme(themeResponseDTO.getTheme());
			}

			Integer article_auteur_id = articleModel.getAuteur_id();
			UserModel auteurModel = this.userRepository.findById(article_auteur_id).orElseThrow();
			if(auteurModel != null){
				article_dto.setAuteur(auteurModel.getName());
			}

			// Mapper chaque CommentaireModel à CommentaireResponseDTO
			List<CommentaireResponseDTO> commentaires_dto = commentaireModels.stream().map(commentaire -> {
				CommentaireResponseDTO commentaireDTO = modelMapper.map(commentaire, CommentaireResponseDTO.class);

				// Récupérer l'auteur du commentaire
				UserModel userModel = this.userRepository.findById(commentaire.getAuteur_id()).orElseThrow();
				commentaireDTO.setUser_str(userModel.getName());
				System.out.println("commentaireDTO:" + commentaireDTO.toString());
				return commentaireDTO;
			}).collect(Collectors.toList());

			// Ajouter les commentaires à ArticleResponseDTO
			article_dto.setCommentaires(commentaires_dto);

			return article_dto;
		}
		return null;
	}


	@Override
	public List<ArticleResponseDTO> getAllArticlesForUser(String userEmail) {
		// Récupérer l'utilisateur connecté par email
		UserModel userModel = this.userRepository.findByEmail(userEmail)
				.orElseThrow(() -> new RuntimeException("User not found"));
		Integer userId = userModel.getId();

		// Récupérer tous les theme_id des abonnements de l'utilisateur connecté
		List<Integer> themeIds = this.abonnementRepository.findAllByUserId(userId)
				.stream()
				.map(AbonnementModel::getThemeId) // Utilisez le modèle d'abonnement ici
				.collect(Collectors.toList());
		System.out.println("themeIds:"+themeIds);
		// Récupérer tous les articles ayant ces theme_id
		List<ArticleModel> articleModels = this.articleRepository.findAllByThemeIdIn(themeIds);
		System.out.println(articleModels);
		// Mapper les articles récupérés à ArticleResponseDTO
		List<ArticleResponseDTO> articleResponseDTOs = articleModels.stream()
				.map(article -> {
					ArticleResponseDTO articleDTO = modelMapper.map(article, ArticleResponseDTO.class);

					// Récupérer l'auteur de l'article
					UserModel authorModel = this.userRepository.findById(article.getAuteur_id())
							.orElseThrow(() -> new RuntimeException("Author not found"));
					articleDTO.setAuteur(authorModel.getName());

					// Récupérer le thème de l'article
					ThemeModel themeModel = this.themeRepository.findById(article.getThemeId())
							.orElseThrow(() -> new RuntimeException("Theme not found"));
					articleDTO.setTheme(themeModel.getTheme());

					return articleDTO;
				})
				.collect(Collectors.toList());
		System.out.println(articleResponseDTOs);
		return articleResponseDTOs;
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
		articleCreated.setThemeId(theme_id);
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
