package com.openclassrooms.mddapi.dto;

public class CommentaireResponseDTO {

    private String message;


    public CommentaireResponseDTO() {
    }

    public CommentaireResponseDTO(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
