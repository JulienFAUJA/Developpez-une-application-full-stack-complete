package com.openclassrooms.mddapi.services.Interfaces;

import com.openclassrooms.mddapi.dto.ThemeRequestDTO;
import com.openclassrooms.mddapi.dto.ThemeResponseDTO;

import java.util.List;

public interface IThemeService {


    ThemeResponseDTO getThemeById(Integer id);

    List<ThemeResponseDTO> getAllThemesForUser(String userEmail);
}
