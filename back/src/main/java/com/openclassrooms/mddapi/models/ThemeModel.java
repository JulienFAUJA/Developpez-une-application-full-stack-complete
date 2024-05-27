package com.openclassrooms.mddapi.models;

import jakarta.persistence.*;

/**
 * The type Theme model.
 */
@Entity
@Table(name = "THEMES")
public class ThemeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
     * Instantiates a new Theme model.
     */
    public ThemeModel(){}

    /**
     * Instantiates a new Theme model.
     *
     * @param id          the id
     * @param theme       the theme
     * @param description the description
     */
    public ThemeModel(Integer id, String theme, String description) {
        this.id = id;
        this.theme = theme;
        this.description = description;
    }

    /**
     * Instantiates a new Theme model.
     *
     * @param theme       the theme
     * @param description the description
     */
    public ThemeModel(String theme, String description) {
        this.theme = theme;
        this.description = description;
    }
}
