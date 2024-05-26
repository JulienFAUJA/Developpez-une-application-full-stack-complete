package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.models.ArticleModel;

import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

public class ArticleRequestDTO {

    private String titre;
    private String theme;
    private String contenu;


    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public ArticleRequestDTO() {
    }


    public ArticleRequestDTO(String titre,String theme, String contenu) {
        this.titre = titre;
        this.theme = theme;
        this.contenu = contenu;
    }

    public ArticleRequestDTO(ArticleModel article) {
        this.titre = article.getTitre();
        this.contenu = article.getContenu();

    }

    @Override
    public String toString() {
        return "ArticleRequestDTO [titre=" + this.getTitre() + ", theme=" + this.getTheme() + ", contenu=" + this.getContenu()+"]";
    }


	


    
}

