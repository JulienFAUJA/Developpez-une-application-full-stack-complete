package com.openclassrooms.mddapi.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * The type Commentaire model.
 */
@Entity
@Table(name = "COMMENTAIRES")
public class CommentaireModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String contenu;
    @Column(name = "article_id")
    private Integer articleId;
    @Column(name = "user_id")
    private Integer auteur_id;
    /**
     * The Created at.
     */
    public Timestamp created_at;


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
     * Gets article id.
     *
     * @return the article id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * Sets article id.
     *
     * @param articleId the article id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * Gets auteur id.
     *
     * @return the auteur id
     */
    public Integer getAuteur_id() {
        return auteur_id;
    }

    /**
     * Sets auteur id.
     *
     * @param auteur_id the auteur id
     */
    public void setAuteur_id(Integer auteur_id) {
        this.auteur_id = auteur_id;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /**
     * Sets created at.
     *
     * @param created_at the created at
     */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /**
     * Sets created at now.
     */
    public void setCreated_atNow() {
        Timestamp now = Timestamp.from(Instant.now());
        this.setCreated_at(now);
    }


    /**
     * Instantiates a new Commentaire model.
     */
    public CommentaireModel(){}

    /**
     * Instantiates a new Commentaire model.
     *
     * @param id         the id
     * @param contenu    the contenu
     * @param articleId  the article id
     * @param auteur_id  the auteur id
     * @param created_at the created at
     */
    public CommentaireModel(Integer id, String contenu, Integer articleId, Integer auteur_id, Timestamp created_at) {
        this.id = id;
        this.contenu = contenu;
        this.articleId = articleId;
        this.auteur_id = auteur_id;
        this.created_at=created_at;
    }

    /**
     * Instantiates a new Commentaire model.
     *
     * @param id        the id
     * @param contenu   the contenu
     * @param articleId the article id
     * @param auteur_id the auteur id
     */
    public CommentaireModel(Integer id, String contenu, Integer articleId, Integer auteur_id) {
        this.id = id;
        this.contenu = contenu;
        this.articleId = articleId;
        this.auteur_id = auteur_id;
    }

    /**
     * Instantiates a new Commentaire model.
     *
     * @param contenu   the contenu
     * @param articleId the article id
     * @param auteur_id the auteur id
     */
    public CommentaireModel(String contenu, Integer articleId, Integer auteur_id) {
        this.contenu = contenu;
        this.articleId = articleId;
        this.auteur_id = auteur_id;
    }

    /**
     * Instantiates a new Commentaire model.
     *
     * @param contenu    the contenu
     * @param articleId  the article id
     * @param auteur_id  the auteur id
     * @param created_at the created at
     */
    public CommentaireModel(String contenu, Integer articleId, Integer auteur_id, Timestamp created_at) {
        this.contenu = contenu;
        this.articleId = articleId;
        this.auteur_id = auteur_id;
        this.created_at=created_at;
    }

    /**
     * Instantiates a new Commentaire model.
     *
     * @param contenu   the contenu
     * @param auteur_id the auteur id
     */
    public CommentaireModel(String contenu, Integer auteur_id) {
        this.contenu = contenu;
        this.auteur_id = auteur_id;
    }

    @Override
    public String toString() {
        return "CommentaireModel [id="+this.getId()+ ", contenu=" + this.getContenu() + ", auteur=" + this.getAuteur_id() +  ", createdAt=" + this.getCreated_at()+"]";
    }
}
