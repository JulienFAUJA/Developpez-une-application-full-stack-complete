package com.openclassrooms.mddapi.models;

import jakarta.persistence.*;

@Entity
@Table(name = "THEMES")
public class ThemeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String theme;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ThemeModel(Integer id, String theme, String description) {
        this.id = id;
        this.theme = theme;
        this.description = description;
    }

    public ThemeModel(String theme, String description) {
        this.theme = theme;
        this.description = description;
    }
}
