package com.openclassrooms.mddapi.dto;

import java.sql.Timestamp;
import java.util.List;

/**
 * The type Article response dto.
 */
public class ArticleResponseDTO {

	private Integer id;
	private String auteur;
	private String theme;
	private String titre;
	private String contenu;
	private List<CommentaireResponseDTO> commentaires;
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
	 * Gets auteur.
	 *
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * Sets auteur.
	 *
	 * @param auteur the auteur
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

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
	 * Gets commentaires.
	 *
	 * @return the commentaires
	 */
	public List<CommentaireResponseDTO> getCommentaires() {
		return commentaires;
	}

	/**
	 * Sets commentaires.
	 *
	 * @param commentaires the commentaires
	 */
	public void setCommentaires(List<CommentaireResponseDTO> commentaires) {
		this.commentaires = commentaires;
	}

	/**
	 * Instantiates a new Article response dto.
	 */
	public ArticleResponseDTO() {
	}

	/**
	 * Instantiates a new Article response dto.
	 *
	 * @param id        the id
	 * @param auteur    the auteur
	 * @param theme     the theme
	 * @param titre     the titre
	 * @param contenu   the contenu
	 * @param createdAt the created at
	 */
	public ArticleResponseDTO(Integer id, String auteur, String theme, String titre, String contenu, Timestamp createdAt) {
		this.id = id;
		this.auteur = auteur;
		this.theme = theme;
		this.titre = titre;
		this.contenu = contenu;
		this.createdAt = createdAt;
	}

	/**
	 * Instantiates a new Article response dto.
	 *
	 * @param id           the id
	 * @param auteur       the auteur
	 * @param theme        the theme
	 * @param titre        the titre
	 * @param contenu      the contenu
	 * @param commentaires the commentaires
	 * @param createdAt    the created at
	 */
	public ArticleResponseDTO(Integer id, String auteur, String theme, String titre, String contenu, List<CommentaireResponseDTO> commentaires, Timestamp createdAt) {
		this.id = id;
		this.auteur = auteur;
		this.theme = theme;
		this.titre = titre;
		this.contenu = contenu;
		this.commentaires = commentaires;
		this.createdAt = createdAt;
	}
}
