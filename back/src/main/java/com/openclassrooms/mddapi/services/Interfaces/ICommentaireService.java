package com.openclassrooms.mddapi.services.Interfaces;

import com.openclassrooms.mddapi.dto.CommentaireRequestDTO;
import com.openclassrooms.mddapi.dto.CommentaireResponseDTO;

public interface ICommentaireService {

    CommentaireResponseDTO postCommentaire(CommentaireRequestDTO commentaireRequestDTO, String userEmail);
}
