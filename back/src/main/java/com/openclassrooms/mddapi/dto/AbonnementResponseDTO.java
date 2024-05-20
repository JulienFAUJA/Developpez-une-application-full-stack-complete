package com.openclassrooms.mddapi.dto;

public class AbonnementResponseDTO {

    private String message;


    public AbonnementResponseDTO() {
    }

    public AbonnementResponseDTO(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
