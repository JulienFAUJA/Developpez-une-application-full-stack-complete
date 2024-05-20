package com.openclassrooms.mddapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "COMMENTAIRES")
public class CommentaireModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contenu;
    private Integer article_id;
    private Integer auteur_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Integer getAuteur_id() {
        return auteur_id;
    }

    public void setAuteur_id(Integer auteur_id) {
        this.auteur_id = auteur_id;
    }

    public CommentaireModel(Integer id, String contenu, Integer article_id, Integer auteur_id) {
        this.id = id;
        this.contenu = contenu;
        this.article_id = article_id;
        this.auteur_id = auteur_id;
    }

    public CommentaireModel(String contenu, Integer article_id, Integer auteur_id) {
        this.contenu = contenu;
        this.article_id = article_id;
        this.auteur_id = auteur_id;
    }

    public CommentaireModel(String contenu, Integer auteur_id) {
        this.contenu = contenu;
        this.auteur_id = auteur_id;
    }
}
