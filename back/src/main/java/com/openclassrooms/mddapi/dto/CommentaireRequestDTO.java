package com.openclassrooms.mddapi.dto;


public class CommentaireRequestDTO {

    private String contenu;
    private Integer user_id;
    private Integer article_id;



    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }


    public CommentaireRequestDTO() {
    }

    public CommentaireRequestDTO(String contenu, Integer user_id, Integer article_id) {
        this.contenu = contenu;
        this.user_id = user_id;
        this.article_id = article_id;
    }

    public CommentaireRequestDTO(String contenu, Integer article_id) {
        this.contenu = contenu;
        this.article_id = article_id;
    }
}
