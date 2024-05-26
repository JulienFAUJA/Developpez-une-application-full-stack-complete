package com.openclassrooms.mddapi.dto;

import java.sql.Timestamp;
import java.util.List;

public class ArticleResponseDTO {

	private Integer id;
	private String auteur;
	private String theme;
	private String titre;
	private String contenu;
	private List<CommentaireResponseDTO> commentaires;
	private Timestamp createdAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public List<CommentaireResponseDTO> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<CommentaireResponseDTO> commentaires) {
		this.commentaires = commentaires;
	}

	public ArticleResponseDTO() {
	}

	public ArticleResponseDTO(Integer id, String auteur, String theme, String titre, String contenu, Timestamp createdAt) {
		this.id = id;
		this.auteur = auteur;
		this.theme = theme;
		this.titre = titre;
		this.contenu = contenu;
		this.createdAt = createdAt;
	}

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
