package com.openclassrooms.mddapi.models;

import java.sql.Timestamp;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ARTICLES")
public class ArticleModel {


	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titre;
	private Integer theme_id;
	private Integer auteur_id;
	private String contenu;
	private Integer[] commentaires;
	public Timestamp createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getTheme_id() {
		return theme_id;
	}

	public void setTheme_id(Integer theme_id) {
		this.theme_id = theme_id;
	}

	public Integer getAuteur_id() {
		return auteur_id;
	}

	public void setAuteur_id(Integer auteur_id) {
		this.auteur_id = auteur_id;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Timestamp getCreated_at() {
		return createdAt;
	}

	public void setCreated_at(Timestamp created_at) {
		this.createdAt = created_at;
	}


	public void setCreated_atNow() {
		Timestamp now = Timestamp.from(Instant.now());
		this.setCreated_at(now);
	}

	public Integer[] getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Integer[] commentaires) {
		this.commentaires = commentaires;
	}

    public ArticleModel() {
    }

	public ArticleModel(Integer id, String titre, Integer theme_id, Integer auteur_id, String contenu, Integer[] commentaires, Timestamp createdAt) {
		this.id = id;
		this.titre = titre;
		this.theme_id = theme_id;
		this.auteur_id = auteur_id;
		this.contenu = contenu;
		this.commentaires = commentaires;
		this.createdAt = createdAt;
	}

	public ArticleModel(String titre, String contenu, Integer auteur_id, Integer theme_id) {
		this.titre = titre;
		this.contenu = contenu;
		this.auteur_id = auteur_id;
		this.theme_id = theme_id;
	}

	public ArticleModel(String titre, Integer theme_id, Integer auteur_id, String contenu, Timestamp createdAt) {
		this.titre = titre;
		this.theme_id = theme_id;
		this.auteur_id = auteur_id;
		this.contenu = contenu;
		this.createdAt = createdAt;
	}
}
