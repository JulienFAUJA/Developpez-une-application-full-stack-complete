package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.models.ArticleModel;

import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

public class ArticleRequestDTO {


    private Integer id;
    private String titre;
    private String theme;
    private Integer auteur_id;
    private String contenu;
    private Integer[] commentaires;
    public Timestamp createdAt;

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


    public Integer[] getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(Integer[] commentaires) {
        this.commentaires = commentaires;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Integer getAuteur_id() {
        return auteur_id;
    }

    public void setAuteur_id(Integer auteur_id) {
        this.auteur_id = auteur_id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public ArticleRequestDTO() {
    }


    public ArticleRequestDTO(Integer id, Integer auteur_id, String titre,String theme, String contenu) {
        this.id = id;
        this.auteur_id = auteur_id;
        this.titre = titre;
        this.theme = theme;
        this.contenu = contenu;
    }



    public ArticleRequestDTO(ArticleModel article) {
        this.id=article.getId();
        this.auteur_id = article.getAuteur_id();
        this.titre = article.getTitre();
        this.contenu = article.getContenu();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


	


    
}

