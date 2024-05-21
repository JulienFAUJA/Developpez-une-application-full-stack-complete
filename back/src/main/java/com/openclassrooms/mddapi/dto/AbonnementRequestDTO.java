package com.openclassrooms.mddapi.dto;

public class AbonnementRequestDTO {

    private Integer theme_id;


    public Integer getThemeId() {
        return theme_id;
    }

    public void setThemeId(Integer theme_id) {
        this.theme_id = theme_id;
    }

    public AbonnementRequestDTO(){}

    public AbonnementRequestDTO(Integer theme_id) {
        this.theme_id = theme_id;
    }

    @Override
    public String toString() {
        return "AbonnementRequestDTO [themeId=" + this.getThemeId()+"]";
    }

}
