package com.openclassrooms.mddapi.services;

import com.openclassrooms.mddapi.dto.CommentaireRequestDTO;
import com.openclassrooms.mddapi.dto.CommentaireResponseDTO;
import com.openclassrooms.mddapi.services.Interfaces.ICommentaireService;
import org.springframework.stereotype.Service;

@Service
public class CommentaireService implements ICommentaireService {



    @Override
    public CommentaireResponseDTO getCommentaireById(Integer id) {
        return null;
    }

    @Override
    public CommentaireResponseDTO postCommentaire(CommentaireRequestDTO commentaireRequestDTO) {
        return null;
    }
}
