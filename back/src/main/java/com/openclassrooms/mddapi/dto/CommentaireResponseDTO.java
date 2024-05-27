package com.openclassrooms.mddapi.dto;

import java.sql.Timestamp;

/**
 * The type Commentaire response dto.
 */
public class CommentaireResponseDTO {

    private Integer id;
    private String contenu;
    private String user_str;
    private Integer article_id;
    private Timestamp createdAt;


    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * Gets user str.
     *
     * @return the user str
     */
    public String getUser_str() {
        return user_str;
    }

    /**
     * Sets user str.
     *
     * @param user_str the user str
     */
    public void setUser_str(String user_str) {
        this.user_str = user_str;
    }

    /**
     * Gets article id.
     *
     * @return the article id
     */
    public Integer getArticle_id() {
        return article_id;
    }

    /**
     * Sets article id.
     *
     * @param article_id the article id
     */
    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Instantiates a new Commentaire response dto.
     */
    public CommentaireResponseDTO(){

    }

    /**
     * Instantiates a new Commentaire response dto.
     *
     * @param id         the id
     * @param contenu    the contenu
     * @param article_id the article id
     * @param createdAt  the created at
     */
    public CommentaireResponseDTO(Integer id, String contenu,  Integer article_id, Timestamp createdAt) {
        this.id = id;
        this.contenu = contenu;
        this.article_id = article_id;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CommentaireResponseDTO [id=" + this.getId()+"contenu=" + this.getContenu()+", User_str=" + this.getUser_str()+", createdAt=" + this.getCreatedAt()+"]";
    }
}
