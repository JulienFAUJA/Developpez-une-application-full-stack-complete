package com.openclassrooms.mddapi.services.Interfaces;

import com.openclassrooms.mddapi.dto.CommentaireRequestDTO;
import com.openclassrooms.mddapi.dto.CommentaireResponseDTO;

/**
 * The interface Commentaire service.
 */
public interface ICommentaireService {

    /**
     * Post commentaire commentaire response dto.
     *
     * @param commentaireRequestDTO the commentaire request dto
     * @param userEmail             the user email
     * @return the commentaire response dto
     */
    CommentaireResponseDTO postCommentaire(CommentaireRequestDTO commentaireRequestDTO, String userEmail);
}
