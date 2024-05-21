package com.openclassrooms.mddapi.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.Instant;

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
    public Timestamp created_at;


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

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getAuteur_id() {
        return auteur_id;
    }

    public void setAuteur_id(Integer auteur_id) {
        this.auteur_id = auteur_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public void setCreated_atNow() {
        Timestamp now = Timestamp.from(Instant.now());
        this.setCreated_at(now);
    }


    public CommentaireModel(){}

    public CommentaireModel(Integer id, String contenu, Integer articleId, Integer auteur_id, Timestamp created_at) {
        this.id = id;
        this.contenu = contenu;
        this.articleId = articleId;
        this.auteur_id = auteur_id;
        this.created_at=created_at;
    }

    public CommentaireModel(Integer id, String contenu, Integer articleId, Integer auteur_id) {
        this.id = id;
        this.contenu = contenu;
        this.articleId = articleId;
        this.auteur_id = auteur_id;
    }

    public CommentaireModel(String contenu, Integer articleId, Integer auteur_id) {
        this.contenu = contenu;
        this.articleId = articleId;
        this.auteur_id = auteur_id;
    }

    public CommentaireModel(String contenu, Integer articleId, Integer auteur_id, Timestamp created_at) {
        this.contenu = contenu;
        this.articleId = articleId;
        this.auteur_id = auteur_id;
        this.created_at=created_at;
    }

    public CommentaireModel(String contenu, Integer auteur_id) {
        this.contenu = contenu;
        this.auteur_id = auteur_id;
    }

    @Override
    public String toString() {
        return "CommentaireModel [id="+this.getId()+ ", contenu=" + this.getContenu() + ", auteur=" + this.getAuteur_id() +  ", createdAt=" + this.getCreated_at()+"]";
    }
}
