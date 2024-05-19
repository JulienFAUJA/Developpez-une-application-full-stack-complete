package com.openclassrooms.mddapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "COMMENTAIRES")
public class CommentaireModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
