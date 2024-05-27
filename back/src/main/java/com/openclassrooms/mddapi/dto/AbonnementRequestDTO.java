package com.openclassrooms.mddapi.dto;

/**
 * The type Abonnement request dto.
 */
public class AbonnementRequestDTO {

    private Integer theme_id;


    /**
     * Gets theme id.
     *
     * @return the theme id
     */
    public Integer getThemeId() {
        return theme_id;
    }

    /**
     * Sets theme id.
     *
     * @param theme_id the theme id
     */
    public void setThemeId(Integer theme_id) {
        this.theme_id = theme_id;
    }

    /**
     * Instantiates a new Abonnement request dto.
     */
    public AbonnementRequestDTO(){}

    /**
     * Instantiates a new Abonnement request dto with theme id.
     *
     * @param theme_id the theme id
     */
    public AbonnementRequestDTO(Integer theme_id) {
        this.theme_id = theme_id;
    }

    @Override
    public String toString() {
        return "AbonnementRequestDTO [themeId=" + this.getThemeId()+"]";
    }

}
