package com.openclassrooms.mddapi.dto;

/**
 * The type Theme response dto.
 */
public class ThemeResponseDTO {

    private Integer id;
    private String theme;
    private String description;
    private boolean isSubscribed;

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
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets is subscribed.
     *
     * @return the is subscribed
     */
    public boolean getIsSubscribed() {
        return isSubscribed;
    }

    /**
     * Sets is subscribed.
     *
     * @param subscribed the subscribed
     */
    public void setIsSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    /**
     * Instantiates a new Theme response dto.
     */
    public ThemeResponseDTO(){}

    /**
     * Instantiates a new Theme response dto.
     *
     * @param id           the id
     * @param theme        the theme
     * @param description  the description
     * @param isSubscribed the is subscribed
     */
    public ThemeResponseDTO(Integer id, String theme, String description, boolean isSubscribed) {
        this.id = id;
        this.theme = theme;
        this.description = description;
        this.isSubscribed = isSubscribed;
    }
}
