package com.openclassrooms.mddapi.dto;


public class CommentaireRequestDTO {

    private String contenu;
    private Integer article_id;
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


    public CommentaireRequestDTO() {
    }

    public CommentaireRequestDTO(String contenu, Integer article_id) {
        this.contenu = contenu;
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "CommentaireRequestDTO [contenu=" + this.getContenu()+", articleId=" + this.getArticle_id()+"]";
    }
}
