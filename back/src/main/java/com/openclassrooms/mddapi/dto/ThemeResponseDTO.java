package com.openclassrooms.mddapi.dto;

public class ThemeResponseDTO {

    private String message;


    public ThemeResponseDTO() {
    }

    public ThemeResponseDTO(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
