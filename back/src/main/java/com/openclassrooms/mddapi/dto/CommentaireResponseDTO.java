package com.openclassrooms.mddapi.dto;

import java.sql.Timestamp;

public class CommentaireResponseDTO {

    private Integer id;
    private String contenu;
    private String user_str;
    private Integer article_id;
    private Timestamp createdAt;


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

    public String getUser_str() {
        return user_str;
    }

    public void setUser_str(String user_str) {
        this.user_str = user_str;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public CommentaireResponseDTO(){

    }

    public CommentaireResponseDTO(Integer id, String contenu,  Integer article_id, Timestamp createdAt) {
        this.id = id;
        this.contenu = contenu;
        this.article_id = article_id;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CommentaireResponseDTO [id=" + this.getId()+"contenu=" + this.getContenu()+", articleId=" + this.getArticle_id()+", createdAt=" + this.getCreatedAt()+"]";
    }
}
