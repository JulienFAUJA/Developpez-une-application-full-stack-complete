package com.openclassrooms.mddapi.models;

import java.sql.Timestamp;
import java.time.Instant;

import jakarta.persistence.*;


@Entity
@Table(name = "ARTICLES")
public class ArticleModel {


	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titre;
	@Column(name = "theme_id")
	private Integer themeId;
	private Integer auteur_id;
	private String contenu;
	public Timestamp created_at;

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

	public Integer getThemeId() {
		return themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
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
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}


	public void setCreated_atNow() {
		Timestamp now = Timestamp.from(Instant.now());
		this.setCreated_at(now);
	}


    public ArticleModel() {
    }

	public ArticleModel(Integer id, String titre, Integer themeId, Integer auteur_id, String contenu, Timestamp created_at) {
		this.id = id;
		this.titre = titre;
		this.themeId = themeId;
		this.auteur_id = auteur_id;
		this.contenu = contenu;
		this.created_at = created_at;
	}

	public ArticleModel(String titre, String contenu, Integer auteur_id, Integer themeId) {
		this.titre = titre;
		this.contenu = contenu;
		this.auteur_id = auteur_id;
		this.themeId = themeId;
	}

	public ArticleModel(String titre, Integer themeId, Integer auteur_id, String contenu, Timestamp created_at) {
		this.titre = titre;
		this.themeId = themeId;
		this.auteur_id = auteur_id;
		this.contenu = contenu;
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "ArticleModel [id="+this.getId()+", titre=" + this.getTitre() + ", theme=" + this.getThemeId() + ", contenu=" + this.getContenu()
				+ ", auteur=" + this.getAuteur_id()+", created_at:"+this.getCreated_at()+"]";
	}
}
