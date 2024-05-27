package com.openclassrooms.mddapi.controllers;

import com.openclassrooms.mddapi.dto.CommentaireRequestDTO;
import com.openclassrooms.mddapi.dto.CommentaireResponseDTO;
import com.openclassrooms.mddapi.services.Interfaces.ICommentaireService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * The type Commentaire controller.
 */
@RestController
@RequestMapping("/api/commentaire")
public class CommentaireController {

    @Autowired
    private ICommentaireService commentaireService;


    /**
     * Post commentaire method.
     *
     * @param commentaireRequestDTO the commentaire request dto
     * @param authentication        the authentication
     * @return the response entity
     */
    @ResponseBody
    @PostMapping("/create")
    public ResponseEntity<?> postCommentaire(@Valid @RequestBody CommentaireRequestDTO commentaireRequestDTO, Authentication authentication) {
        String userEmail = authentication.getName();
        CommentaireResponseDTO commentaireResponseDTO = commentaireService.postCommentaire(commentaireRequestDTO, userEmail);
        if (commentaireResponseDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
        }
        return ResponseEntity.ok(commentaireResponseDTO);
    }


}
