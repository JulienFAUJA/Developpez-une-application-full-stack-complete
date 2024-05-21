package com.openclassrooms.mddapi.dto;

import java.util.List;

public class UserProfileResponseDTO {
    private UserLoggedDTO user;
    private List<ThemeResponseDTO> subscribedThemes;

    public UserLoggedDTO getUser() {
        return user;
    }

    public void setUser(UserLoggedDTO user) {
        this.user = user;
    }

    public List<ThemeResponseDTO> getSubscribedThemes() {
        return subscribedThemes;
    }

    public void setSubscribedThemes(List<ThemeResponseDTO> subscribedThemes) {
        this.subscribedThemes = subscribedThemes;
    }

    public UserProfileResponseDTO(){}

    public UserProfileResponseDTO(UserLoggedDTO user, List<ThemeResponseDTO> subscribedThemes) {
        this.user = user;
        this.subscribedThemes = subscribedThemes;
    }
}
