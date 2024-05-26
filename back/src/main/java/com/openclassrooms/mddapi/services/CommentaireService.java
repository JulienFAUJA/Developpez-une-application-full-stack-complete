package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.CommentaireRequestDTO;
import com.openclassrooms.mddapi.dto.CommentaireResponseDTO;
import com.openclassrooms.mddapi.models.CommentaireModel;
import com.openclassrooms.mddapi.models.UserModel;
import com.openclassrooms.mddapi.repositories.ArticleRepository;
import com.openclassrooms.mddapi.repositories.CommentaireRepository;
import com.openclassrooms.mddapi.repositories.UserRepository;
import com.openclassrooms.mddapi.services.Interfaces.ICommentaireService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CommentaireService implements ICommentaireService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentaireResponseDTO postCommentaire(CommentaireRequestDTO commentaireRequestDTO, String userEmail) {
        // Valider les données d'entrée
        UserModel userModel = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email"));

        // Mapper CommentaireRequestDTO à CommentaireModel
        CommentaireModel commentaireModel = modelMapper.map(commentaireRequestDTO, CommentaireModel.class);
        commentaireModel.setArticleId(commentaireRequestDTO.getArticle_id());
        commentaireModel.setCreated_atNow();
        commentaireModel.setAuteur_id(userModel.getId());

        // Sauvegarder le commentaire dans la base de données
        CommentaireModel savedCommentaire = commentaireRepository.save(commentaireModel);

        // Mapper le commentaire sauvegardé à CommentaireResponseDTO
        CommentaireResponseDTO commentaireResponseDTO = modelMapper.map(savedCommentaire, CommentaireResponseDTO.class);
        commentaireResponseDTO.setUser_str(userModel.getName());

        return commentaireResponseDTO;
    }
}

