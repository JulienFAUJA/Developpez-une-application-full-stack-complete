package com.openclassrooms.mddapi.dto;

import java.util.List;

/**
 * The type User profile response dto.
 */
public class UserProfileResponseDTO {
    private UserLoggedDTO user;
    private List<ThemeResponseDTO> subscribedThemes;

    /**
     * Gets user.
     *
     * @return the user
     */
    public UserLoggedDTO getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(UserLoggedDTO user) {
        this.user = user;
    }

    /**
     * Gets subscribed themes.
     *
     * @return the subscribed themes
     */
    public List<ThemeResponseDTO> getSubscribedThemes() {
        return subscribedThemes;
    }

    /**
     * Sets subscribed themes.
     *
     * @param subscribedThemes the subscribed themes
     */
    public void setSubscribedThemes(List<ThemeResponseDTO> subscribedThemes) {
        this.subscribedThemes = subscribedThemes;
    }

    /**
     * Instantiates a new User profile response dto.
     */
    public UserProfileResponseDTO(){}

    /**
     * Instantiates a new User profile response dto.
     *
     * @param user             the user
     * @param subscribedThemes the subscribed themes
     */
    public UserProfileResponseDTO(UserLoggedDTO user, List<ThemeResponseDTO> subscribedThemes) {
        this.user = user;
        this.subscribedThemes = subscribedThemes;
    }
}
