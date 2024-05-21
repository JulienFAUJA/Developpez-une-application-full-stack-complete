package com.openclassrooms.mddapi.dto;

public class ThemeResponseDTO {

    private Integer id;
    private String theme;
    private String description;
    private boolean isSubscribed;

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

    public boolean getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    public ThemeResponseDTO(){}

    public ThemeResponseDTO(Integer id, String theme, String description, boolean isSubscribed) {
        this.id = id;
        this.theme = theme;
        this.description = description;
        this.isSubscribed = isSubscribed;
    }
}
