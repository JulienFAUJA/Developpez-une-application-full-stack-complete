package com.openclassrooms.mddapi.dto;

/**
 * The type Theme request dto.
 */
public class ThemeRequestDTO {

    private Integer id;
    private String theme;
    private String description;

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
     * Instantiates a new Theme request dto.
     *
     * @param id          the id
     * @param theme       the theme
     * @param description the description
     */
    public ThemeRequestDTO(Integer id, String theme, String description) {
        this.id = id;
        this.theme = theme;
        this.description = description;
    }

    /**
     * Instantiates a new Theme request dto.
     *
     * @param theme       the theme
     * @param description the description
     */
    public ThemeRequestDTO(String theme, String description) {
        this.theme = theme;
        this.description = description;
    }

    /**
     * Instantiates a new Theme request dto.
     *
     * @param id    the id
     * @param theme the theme
     */
    public ThemeRequestDTO(Integer id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    /**
     * Instantiates a new Theme request dto.
     *
     * @param theme the theme
     */
    public ThemeRequestDTO(String theme) {
        this.theme = theme;
    }
}
