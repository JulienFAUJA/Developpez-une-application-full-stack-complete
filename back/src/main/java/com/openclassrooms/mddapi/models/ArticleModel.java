package com.openclassrooms.mddapi.models;

import java.sql.Timestamp;
import java.time.Instant;

import jakarta.persistence.*;


/**
 * The type Article model.
 */
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
	 * Gets theme id.
	 *
	 * @return the theme id
	 */
	public Integer getThemeId() {
		return themeId;
	}

	/**
	 * Sets theme id.
	 *
	 * @param themeId the theme id
	 */
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
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
	 * Instantiates a new Article model.
	 */
	public ArticleModel() {
    }

	/**
	 * Instantiates a new Article model.
	 *
	 * @param id         the id
	 * @param titre      the titre
	 * @param themeId    the theme id
	 * @param auteur_id  the auteur id
	 * @param contenu    the contenu
	 * @param created_at the created at
	 */
	public ArticleModel(Integer id, String titre, Integer themeId, Integer auteur_id, String contenu, Timestamp created_at) {
		this.id = id;
		this.titre = titre;
		this.themeId = themeId;
		this.auteur_id = auteur_id;
		this.contenu = contenu;
		this.created_at = created_at;
	}

	/**
	 * Instantiates a new Article model.
	 *
	 * @param titre     the titre
	 * @param contenu   the contenu
	 * @param auteur_id the auteur id
	 * @param themeId   the theme id
	 */
	public ArticleModel(String titre, String contenu, Integer auteur_id, Integer themeId) {
		this.titre = titre;
		this.contenu = contenu;
		this.auteur_id = auteur_id;
		this.themeId = themeId;
	}

	/**
	 * Instantiates a new Article model.
	 *
	 * @param titre      the titre
	 * @param themeId    the theme id
	 * @param auteur_id  the auteur id
	 * @param contenu    the contenu
	 * @param created_at the created at
	 */
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
