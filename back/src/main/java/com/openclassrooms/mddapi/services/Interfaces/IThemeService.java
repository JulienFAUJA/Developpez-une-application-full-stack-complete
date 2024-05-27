package com.openclassrooms.mddapi.services.Interfaces;

import com.openclassrooms.mddapi.dto.ThemeRequestDTO;
import com.openclassrooms.mddapi.dto.ThemeResponseDTO;

import java.util.List;

/**
 * The interface Theme service.
 */
public interface IThemeService {


    /**
     * Gets theme by id.
     *
     * @param id the id
     * @return the theme by id
     */
    ThemeResponseDTO getThemeById(Integer id);

    /**
     * Gets all themes for user.
     *
     * @param userEmail the user email
     * @return the all themes for user
     */
    List<ThemeResponseDTO> getAllThemesForUser(String userEmail);

    /**
     * Gets all themes.
     *
     * @param userEmail the user email
     * @return the all themes
     */
    List<ThemeResponseDTO> getAllThemes(String userEmail);
}
