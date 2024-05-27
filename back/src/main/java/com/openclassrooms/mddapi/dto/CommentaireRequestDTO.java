package com.openclassrooms.mddapi.dto;


/**
 * The type Commentaire request dto.
 */
public class CommentaireRequestDTO {

    private String contenu;
    private Integer article_id;

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
     * Instantiates a new Commentaire request dto.
     */
    public CommentaireRequestDTO() {
    }

    /**
     * Instantiates a new Commentaire request dto.
     *
     * @param contenu    the contenu
     * @param article_id the article id
     */
    public CommentaireRequestDTO(String contenu, Integer article_id) {
        this.contenu = contenu;
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "CommentaireRequestDTO [contenu=" + this.getContenu()+", articleId=" + this.getArticle_id()+"]";
    }
}
