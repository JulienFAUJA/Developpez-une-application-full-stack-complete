package com.openclassrooms.mddapi.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commentaire")
public class CommentaireController {

    @Autowired
    private ICommentaireService commentaireService;


    @PostMapping
    @ResponseBody
    public ResponseEntity<?> postCommentaire(@Valid @RequestBody CommentaireRequestDTO commentaireRequestDTO) {
        CommentaireResponseDTO commentaireResponseDTO = commentaireService.postCommentaire(commentaireRequestDTO);
        if (commentaireResponseDTO.getMessage() == "Bad request: ") {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(commentaireResponseDTO);
        }
        else if (commentaireResponseDTO.getMessage() == "Unauthorized: ") {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(commentaireResponseDTO);
        }
        else {
            return ResponseEntity.ok(commentaireResponseDTO);
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCommentairesById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(commentaireService.getThemeById(id));
    }

}
