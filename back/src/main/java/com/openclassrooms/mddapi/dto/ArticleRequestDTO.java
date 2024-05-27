package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.models.ArticleModel;

import jakarta.validation.constraints.NotBlank;

import java.sql.Timestamp;

/**
 * The type Article request dto.
 */
public class ArticleRequestDTO {

    private String titre;
    private String theme;
    private String contenu;


    /**
     * Gets theme.
     *
     * @return the theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Sets theme.
     *
     * @param theme the theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Gets contenu.
     *
     * @return the contenu
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * Sets contenu.
     *
     * @param contenu the contenu
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }


    /**
     * Gets titre.
     *
     * @return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Sets titre.
     *
     * @param titre the titre
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Instantiates a new Article request dto.
     */
    public ArticleRequestDTO() {
    }


    /**
     * Instantiates a new Article request dto.
     *
     * @param titre   the titre
     * @param theme   the theme
     * @param contenu the contenu
     */
    public ArticleRequestDTO(String titre,String theme, String contenu) {
        this.titre = titre;
        this.theme = theme;
        this.contenu = contenu;
    }

    /**
     * Instantiates a new Article request dto.
     *
     * @param article the article
     */
    public ArticleRequestDTO(ArticleModel article) {
        this.titre = article.getTitre();
        this.contenu = article.getContenu();

    }

    @Override
    public String toString() {
        return "ArticleRequestDTO [titre=" + this.getTitre() + ", theme=" + this.getTheme() + ", contenu=" + this.getContenu()+"]";
    }


	


    
}

